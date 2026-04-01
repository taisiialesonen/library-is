# 📚 Library IS

Система управления библиотекой на Spring Boot.

---

## Требования

Перед запуском убедись, что установлено:

- [Java 25+](https://jdk.java.net/)
- [Docker Desktop](https://www.docker.com/products/docker-desktop/)
- [Git](https://git-scm.com/)

---

## Быстрый старт

### 1. Клонировать репозиторий

```bash
git clone https://github.com/taisiialesonen/library-is.git
cd library-is
```

---

### 2. Создать `.env` файл

В корне проекта создай файл `.env` со следующим содержимым:

```properties
# Database configuration
DB_USERNAME=
DB_PASSWORD=
DB_NAME=
DB_URL=

# PgAdmin configuration
PGA_USERNAME=
PGA_PASSWORD=
```
---

### 3. Запустить инфраструктуру через Docker

Перейди в директорию с Docker Compose файлом и запусти контейнеры:

```bash
cd tools/docker
docker compose --env-file ../../.env up -d
```

Это поднимет два контейнера:

| Контейнер | Описание         | Адрес                                   |
|-----------|------------------|-----------------------------------------|
| postgres  | PostgreSQL 17.9  | `localhost:5432`                        |
| pgadmin   | Веб-интерфейс БД | [localhost:5050](http://localhost:5050) |

Убедись, что контейнеры запустились:

```bash
docker compose --env-file ../../.env ps
```

Все контейнеры должны иметь статус `running`.

---

### 4. Запустить приложение

Запусти главный класс приложения:

```
src/main/java/com/taisiialesonen/libraryis/LibraryIsApplication.java
```

Или через Gradle:

```bash
./gradlew bootRun
```

После успешного старта приложение будет доступно по адресу [http://localhost:8080](http://localhost:8080).

---

## Полезные ссылки

| Сервис     | URL                                                                            |
|------------|--------------------------------------------------------------------------------|
| Приложение | [http://localhost:8080](http://localhost:8080)                                 |
| Swagger UI | [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) |
| pgAdmin    | [http://localhost:5050](http://localhost:5050)                                 |
| Actuator   | [http://localhost:8080/actuator](http://localhost:8080/actuator)               |

---

## Остановка

```bash
cd tools/docker
docker compose --env-file ../../.env down
```

Чтобы также удалить данные базы:

```bash
docker compose --env-file ../../.env down -v
rmdir /s /q pgdata   # Windows
rm -rf pgdata        # Linux / macOS
```
