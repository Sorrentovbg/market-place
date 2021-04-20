--drop schema if exists marketplace cascade;

create schema if not exists marketplace;

drop table if exists user_cashback cascade;
drop table if exists orders_status cascade;
drop table if exists product_category cascade;
drop table if exists product_comment cascade;
drop table if exists product_item_storage cascade;

drop table if exists users cascade;
drop table if exists cashback cascade;
drop table if exists orders cascade;
drop table if exists status cascade;
drop table if exists product cascade;
drop table if exists product_item cascade;
drop table if exists comment cascade;
drop table if exists category cascade;
drop table if exists storage cascade;

---------------------UserAndCashbackAndOrder--------------------------------------

create table orders (
    order_id    bigserial,
    orders      bigserial,
    primary key (order_id)
);

create table users (
    user_id     bigserial,
    username    varchar(35) not null,
    password    varchar(80) not null,
    primary key (user_id),
    foreign key (user_id) references orders (order_id)
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




create table status (
    status_id       bigserial,
    orders_status   varchar(35) not null,
    primary key (status_id)
);

create table orders_status (
    order_id       bigint not null,
    status_id      bigint not null,
    primary key (order_id, status_id),
    foreign key (order_id) references orders (order_id),
    foreign key (status_id) references status (status_id)
);

----------------------PRODUCT-------------------------------------------

create table product_item (
    product_item_id          bigserial,
    product_name             varchar(500) not null,
    primary key (product_item_id)
);

create table product (
    product_id          bigserial,
    product_name        varchar(250) not null,
    product_price       integer not null,
    product_picture     varchar(256),
    primary key (product_id),
    foreign key (product_id) references product_item(product_item_id)
);

----------------------CategoryAndComment------------------------------------------

create table category (
    category_id          bigserial,
    category_name        varchar(50) not null,
    primary key (category_id)
);

create table comment (
    comment_id          bigserial,
    comment             varchar(500) not null,
    primary key (comment_id)
);

create table product_category (
    product_id          bigint not null,
    category_id         bigint not null,
    primary key (product_id, category_id),
    foreign key (product_id) references product(product_id),
    foreign key (category_id) references category(category_id)
);

create table product_comment (
    product_id          bigint not null,
    comment_id          bigint not null,
    primary key (product_id, comment_id),
    foreign key (product_id) references product(product_id),
    foreign key (comment_id) references comment(comment_id)
);

-----------------------Storage--------------------------------------------
create table storage (
    storage_id          bigserial,
    storage_name        varchar(50) not null,
    storage_address        varchar(100) not null,
    primary key (storage_id)
);

create table product_item_storage (
    product_item_id          bigint not null,
    storage_id          bigint not null,
    primary key (product_item_id, storage_id),
    foreign key (product_item_id) references product_item(product_item_id),
    foreign key (storage_id) references storage(storage_id)
);