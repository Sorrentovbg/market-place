CREATE SCHEMA if not exists user_sh;

create table users (
    user_id     bigserial,
    username    varchar(35) not null,
    password    varchar(80) not null,
    primary key (user_id)
--    foreign key (user_id) references orders (order_id)
);

