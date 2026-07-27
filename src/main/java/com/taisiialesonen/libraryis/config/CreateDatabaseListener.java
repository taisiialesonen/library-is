package com.taisiialesonen.libraryis.config;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Создаёт целевую PostgreSQL-базу при старте, если её ещё нет.
 * Нужен потому, что POSTGRES_DB в Docker создаёт БД только при первой инициализации volume.
 */
public class CreateDatabaseListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    private static final Pattern JDBC_URL_PATTERN = Pattern.compile(
            "^jdbc:postgresql://([^/]+)/([^?]+)(.*)$"
    );

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment env = event.getEnvironment();
        String url = env.getProperty("spring.datasource.url");
        String username = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password", "");

        if (url == null || username == null) {
            return;
        }

        Matcher matcher = JDBC_URL_PATTERN.matcher(url);
        if (!matcher.matches()) {
            return;
        }

        String hostPort = matcher.group(1);
        String database = matcher.group(2);
        String query = matcher.group(3);
        String adminUrl = "jdbc:postgresql://" + hostPort + "/postgres" + query;

        try {
            Class.forName("org.postgresql.Driver");
            try (Connection connection = DriverManager.getConnection(adminUrl, username, password);
                 Statement statement = connection.createStatement()) {

                boolean exists;
                String escapedName = database.replace("'", "''");
                try (ResultSet rs = statement.executeQuery(
                        "SELECT 1 FROM pg_database WHERE datname = '" + escapedName + "'")) {
                    exists = rs.next();
                }

                if (!exists) {
                    String quotedName = "\"" + database.replace("\"", "\"\"") + "\"";
                    statement.executeUpdate("CREATE DATABASE " + quotedName);
                }
            }
        } catch (Exception e) {
            throw new IllegalStateException(
                    "Failed to ensure database '%s' exists. Check that PostgreSQL is running and credentials are correct."
                            .formatted(database),
                    e
            );
        }
    }
}
