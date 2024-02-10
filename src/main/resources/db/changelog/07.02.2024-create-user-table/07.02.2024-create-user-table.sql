CREATE TABLE "user"
(
    id           uuid primary key ,
    name         VARCHAR   NOT NULL,
    surname      VARCHAR   NOT NULL,
    phone_number VARCHAR   NOT NULL UNIQUE,
    email        VARCHAR UNIQUE,
    password     VARCHAR   NOT NULL,
    balance      DOUBLE PRECISION,
    is_verify    boolean default false,
    birth_date   TIMESTAMP,
    gender       varchar NOT NULL,
    created      TIMESTAMP NOT NULL,
    updated      TIMESTAMP NOT NULL
);