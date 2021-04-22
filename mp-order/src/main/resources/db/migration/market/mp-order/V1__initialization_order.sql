CREATE SCHEMA if not exists order_sh;

create table orders (
    order_id    bigserial,
    orders      bigserial,
    primary key (order_id)
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