CREATE TABLE users
(
    id          UUID PRIMARY KEY      DEFAULT gen_random_uuid(),
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    first_name  VARCHAR(255) NOT NULL,
    last_name   VARCHAR(255) NOT NULL,
    patronymic  VARCHAR(255),
    phone VARCHAR(20),
    avatar_url VARCHAR(500),
    role VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'STATUS_ACTIVE',
    address  TEXT,
    birth_date  DATE,
    registration_date  DATE NOT NULL DEFAULT current_date,
    last_login_at TIMESTAMP WITH TIME ZONE,
    created_at  TIMESTAMP    WITH TIME ZONE NOT NULL DEFAULT now(),
    updated_at  TIMESTAMP    WITH TIME ZONE NOT NULL DEFAULT now()
)
