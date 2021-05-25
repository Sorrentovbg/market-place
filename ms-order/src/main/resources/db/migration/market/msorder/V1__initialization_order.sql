CREATE SCHEMA if not exists order_sh;

create table orders (
    order_id        bigserial,
    user_id         bigserial,
    primary key (order_id)
);

create table status (
    status_id       bigserial primary key,
    orders_status   varchar(35) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table order_products (
    order_id        bigserial,
    product_id      bigserial,
    foreign key (order_id) references orders(order_id)
);

create table carts (
    id              bigserial,
    user_id         bigserial,
    total_price     bigserial,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    order_created   bigserial
    primary key (id)
);

create table carts_item (
    cart_item_id            bigserial,
    product_id              bigserial,
    price_per_product       bigserial,
    count_product           bigserial,
    total_price_product     bigserial
    foreign key (cart_item_id) references carts(id)
);

insert into status (status_id,orders_status)
values  ("Not paid"),
        ("Paid"),
        ("Completed");

