CREATE SCHEMA if not exists user_sh;

create table users (
    user_id     bigserial,
    username    varchar(35) not null,
    password    varchar(80) not null,
    primary key (user_id)
--    foreign key (user_id) references orders (order_id)
);

create table cashback (
    cashback_id     bigserial,
    cashback        integer,
    primary key (cashback_id)
);

create table user_cashback (
    user_id         bigint not null,
    cashback_id     bigint not null,
    primary key (user_id, cashback_id),
    foreign key (user_id) references users (user_id),
    foreign key (cashback_id) references cashback (cashback_id)
);