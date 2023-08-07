CREATE DATABASE spartans_mt;
USE spartans_mt;

CREATE TABLE IF NOT EXISTS stores(
	store_id int primary key AUTO_INCREMENT,
    store_name VARCHAR (75) NOT NULL,
    category VARCHAR (50) NOT NULL,
    store_logo blob NOT NULL
    );

select * from stores;

CREATE TABLE IF NOT EXISTS products (
	product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_title VARCHAR(500) NOT NULL,
    product_price DOUBLE NOT NULL,
    product_image BLOB NOT NULL,
    store_id INT NOT NULL,
    foreign key(store_id) references stores (store_id)
);


SELECT * FROM products;


CREATE TABLE IF NOT EXISTS USER(
	user_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR (100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(200) NOT NULL,
    password VARCHAR(20) NOT NULL,
    phone_number VARCHAR(15) NOT NULL
);



SELECT * FROM USER;


CREATE TABLE IF NOT EXISTS ORDERS (
	order_id INT PRIMARY KEY AUTO_INCREMENT,
	user_id int not null,
    payment_status VARCHAR(10) NOT NULL,
    total_price INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);

SELECT * FROM ORDERS;


CREATE TABLE IF NOT EXISTS ORDERED_PRODUCT (
	ordered_product_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quentity INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);


select * from ordered_product;