create schema netology;

create table netology.CUSTOMERS (
    id int auto_increment primary key ,
    name char(50),
    surname char(50),
    age numeric,
    phone_number char(12)
);

