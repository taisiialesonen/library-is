# Library IS

Система управления библиотекой на Spring Boot.

---

## Требования

- [Docker Desktop](https://www.docker.com/products/docker-desktop/) (или Docker Engine + Compose)
- [Git](https://git-scm.com/)
- [Java 25+](https://jdk.java.net/) — для дебага из IDE

`.env` не обязателен — используются дефолты (`library` / `library-is-db`). Чтобы переопределить: `cp .env.example .env`.

---

## Дебаг из IDE (основной способ разработки)

1. Поднять только Postgres:

```bash
docker compose up -d
```

2. Запустить `LibraryIsApplication` из IDE (конфигурация `.run/LibraryIsApplication.run.xml`, профиль `local`)  
   или:

```bash
./gradlew bootRun
```

Приложение слушает [http://localhost:8080](http://localhost:8080) и подключается к `localhost:5432`.

| Сервис     | URL                                                                            |
|------------|--------------------------------------------------------------------------------|
| Приложение | [http://localhost:8080](http://localhost:8080)                                 |
| Swagger UI | [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) |
| Actuator   | [http://localhost:8080/actuator](http://localhost:8080/actuator)               |

---

## Демо через Docker

Полный стек (Postgres + приложение), профиль Spring `demo`:

```bash
docker compose --profile demo up --build
```

---

## Прод через Docker

```bash
docker compose --profile prod up --build -d
```

Spring-профиль: `prod` (без SQL-логов, более тихий logging).

---

## pgAdmin

```bash
docker compose --profile tools up -d
```

Интерфейс: [http://localhost:5050](http://localhost:5050)  
Логин по умолчанию: `admin@library.local` / `admin`

Можно комбинировать: `docker compose --profile demo --profile tools up --build`.

---

## Остановка

```bash
docker compose --profile demo --profile prod --profile tools down
```

С удалением данных БД:

```bash
docker compose --profile demo --profile prod --profile tools down -v
# Windows
rmdir /s /q tools\docker\pgdata
# Linux / macOS
rm -rf tools/docker/pgdata
```
