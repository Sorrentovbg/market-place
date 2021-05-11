insert into users (login, password) values
    ('user', '1q2w3e4r'),
    ('admin', '1q2w3e4r');

insert into roles (id, name) values ( 1, 'ROLE_ADMIN');
insert into roles (id, name) values ( 2, 'ROLE_USER');

insert into user_role (user_id, role_id) values
    (1,2),
    (2,1);