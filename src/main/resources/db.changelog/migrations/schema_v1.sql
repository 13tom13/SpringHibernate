-- changeset tom13:1
create table netology.customer
(
    id           int auto_increment not null primary key,
    name         varchar(255)       not null,
    surname      varchar(255)       not null,
    age          int                not null,
    phone_number varchar(255)       not null
);
