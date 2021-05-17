CREATE SCHEMA if not exists user_sh;

create table role_table
(
    id   bigserial      not null
        constraint role_table_pk
            primary key,
    name varchar(20) not null
);

create table user_table
(
    id       bigserial not null
        constraint user_table_pk
            primary key,
    login    varchar(50),
    password varchar(500),
    role_id  bigint
        constraint user_table_role_table_id_fk
            references role_table
);

create
unique index user_table_login_uindex
    on user_table (login);

insert into role_table(name) values ('ROLE_ADMIN');
insert into role_table(name) values ('ROLE_USER');

--create table users (
--    id          bigserial primary key,
--    login       varchar(35) not null,
--    password    varchar(80) not null
--);
--
--create table roles (
--    id     integer primary key,
--    name   varchar(30) not null
--);
--
--create table user_role (
--    user_id     bigserial not null,
--    role_id     integer not null,
--    primary key (user_id,role_id),
--    foreign key (user_id) references users(id),
--    foreign key (role_id) references roles(id)
--);
--
--insert into users (login, password, role_id) values
--    ('admin', '1',1),
--    ('user', '1',1);
----
--insert into roles (name) values ('ROLE_ADMIN');
--insert into roles (name) values ('ROLE_USER');
--
--insert into user_role (user_id, role_id) values
--    (1,1),
--    (2,2);