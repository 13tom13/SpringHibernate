# example customer
insert into netology.customer(name, surname, age, phone_number)
    value ('Ivan', 'Ivanov', 28, 79039551083);

insert into netology.customer(name, surname, age, phone_number)
    value ('Alexey', 'Ivanov', 23, 79039552356);

insert into netology.customer(name, surname, age, phone_number)
    value ('ALEXEY', 'Pavlov', 24, 79039557845);

insert into netology.customer(name, surname, age, phone_number)
    value ('Sergey', 'Kim', 31, 79039551496);

insert into netology.customer(name, surname, age, phone_number)
    value ('Irina', 'Li', 32, 79039559512);


# example orders
insert into netology.orders(data, customer_id, product_name, amount)
    value ('2023-07-22', 1, 'Kolbasa', 255);

insert into netology.orders(data, customer_id, product_name, amount)
    value ('2023-07-19', 2, 'Beer', 100);

insert into netology.orders(data, customer_id, product_name, amount)
    value ('2023-07-17', 3, 'Duck', 1500);

insert into netology.orders(data, customer_id, product_name, amount)
    value ('2023-07-20', 4, 'Chicken', 450);

insert into netology.orders(data, customer_id, product_name, amount)
    value ('2023-07-20', 5, 'bread, jem', 300);

# example person
insert into netology.persons(name, surname, age, phone_number, city_of_living)
    value ('Ivan', 'Ivanov', 23, '+79939065768', 1);
