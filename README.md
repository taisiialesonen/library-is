# Library IS

Система управления библиотекой на Spring Boot.

---

## Требования

- [Docker Desktop](https://www.docker.com/products/docker-desktop/) (или Docker Engine + Compose)
- [Git](https://git-scm.com/)

Для локальной разработки в IDE дополнительно нужен [Java 25+](https://jdk.java.net/).

---

## Быстрый старт

```bash
git clone https://github.com/taisiialesonen/library-is.git
cd library-is
docker compose up --build
```

После старта:

| Сервис     | URL                                                                            |
|------------|--------------------------------------------------------------------------------|
| Приложение | [http://localhost:8080](http://localhost:8080)                                 |
| Swagger UI | [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) |
| Actuator   | [http://localhost:8080/actuator](http://localhost:8080/actuator)               |

`.env` не обязателен — используются локальные дефолты (`library` / `library-is-db`). Чтобы переопределить, скопируй `.env.example` в `.env`.

---

## Локальная разработка (IDE)

Поднять только базу:

```bash
docker compose up postgres postgres-init -d
```

Затем запусти `LibraryIsApplication` из IDE или:

```bash
./gradlew bootRun
```

Приложение подключится к `localhost:5432/library-is-db` и при необходимости создаст БД само.

---

## pgAdmin

```bash
docker compose --profile tools up -d
```

Интерфейс: [http://localhost:5050](http://localhost:5050)  
Логин по умолчанию: `admin@library.local` / `admin`

---

## Остановка

```bash
docker compose down
```

С удалением данных БД:

```bash
docker compose down -v
# Windows
rmdir /s /q tools\docker\pgdata
# Linux / macOS
rm -rf tools/docker/pgdata
```
