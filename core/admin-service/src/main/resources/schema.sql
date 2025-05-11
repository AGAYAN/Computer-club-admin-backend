CREATE TABLE admin (
    id BIGINT generated always as identity primary key,
    login VARCHAR(55) not null ,
    password VARCHAR(55) not null,
    role VARCHAR(10) not null
)