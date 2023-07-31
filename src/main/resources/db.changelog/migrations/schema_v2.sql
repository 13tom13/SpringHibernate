-- changeset tom13:2
create table netology.orders
(
    id           bigint       not null auto_increment primary key,
    data         varchar(255)         not null,
    customer_id  int          not null,
    product_name varchar(255) not null,
    amount       int          not null,
    foreign key (customer_id) references netology.customer(id)
);

