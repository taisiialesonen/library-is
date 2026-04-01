CREATE TABLE authors
(
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name  VARCHAR(255) NOT NULL,
    last_name   VARCHAR(255) NOT NULL,
    patronymic  VARCHAR(255),
    biography   TEXT,
    birth_date  DATE,
    death_date  DATE,
    nationality VARCHAR(255),
    photo_url   VARCHAR(255),
    created_at  TIMESTAMP    NOT NULL DEFAULT now(),
    updated_at  TIMESTAMP    NOT NULL DEFAULT now()
);
