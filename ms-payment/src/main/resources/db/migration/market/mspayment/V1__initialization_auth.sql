CREATE SCHEMA if not exists payment_sh;


create table cashback (
    cashback_id     bigserial,
    cashback        integer,
    primary key (cashback_id)
);


