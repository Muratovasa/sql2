create table netology.ORDERS (
    id int auto_increment primary key ,
    date int (10),
    customer_id int,
    product_name char(255),
    amount numeric,
   FOREIGN KEY fr_customer_id(customer_id) references netology.CUSTOMERS(id)
);