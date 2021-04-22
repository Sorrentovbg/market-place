CREATE SCHEMA if not exists storage_sh;

create table storage (
    storage_id          bigserial,
    storage_name        varchar(50) not null,
    storage_address        varchar(100) not null,
    primary key (storage_id)
);

--create table product_item_storage (
--    product_item_id          bigint not null,
--    storage_id          bigint not null,
--    primary key (product_item_id, storage_id),
--    foreign key (product_item_id) references product_item(product_item_id),
--    foreign key (storage_id) references storage(storage_id)
--);
