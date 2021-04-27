CREATE SCHEMA if not exists user_sh;

create table users (
    id          bigserial primary key,
    login       varchar(35) not null,
    password    varchar(80) not null
);

create table roles (
    id     integer primary key,
    name   varchar(30) not null
);

create table user_role (
    user_id     bigserial,
    role_id     integer,
    primary key (user_id,role_id),
    foreign key (user_id) references users(id),
    foreign key (role_id) references roles(id)
);