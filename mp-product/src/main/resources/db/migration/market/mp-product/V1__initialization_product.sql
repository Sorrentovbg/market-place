CREATE SCHEMA if not exists product_sh;

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