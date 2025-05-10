CREATE TABLE users (
    Id BIGINT generated always as identity primary key,
    login varchar(55) not null,
    password varchar(55) not null,
    username varchar(55) not null,
    timeUsers TIMESTAMP,
    money int
)