drop schema netology;
create schema products;

create table products.CUSTOMERS (
                                    id int auto_increment primary key ,
                                    name char(50),
                                    surname char(50),
                                    age numeric,
                                    phone_number char(12)
);

create table products.ORDERS (
                                 id int auto_increment primary key ,
                                 date TIMESTAMP,
                                 customer_id int,
                                 product_name char(255),
                                 amount numeric,
                                 FOREIGN KEY fr_customer_id(customer_id) references products.CUSTOMERS(id)
);