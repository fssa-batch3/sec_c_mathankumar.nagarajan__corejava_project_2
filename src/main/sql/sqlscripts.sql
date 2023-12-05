USE mathankumar_nagarajan_corejava_project;

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
    uploaded_date DATE NOT NULL,
    store_id INT NOT NULL,
    foreign key(store_id) references stores (store_id)
);

select * from products;
SELECT product_id, product_title, product_price, product_image, uploaded_date, store_id FROM products WHERE product_id = 2;
select * from products where store_id = 2;

CREATE TABLE IF NOT EXISTS user(
	user_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR (100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(200) UNIQUE NOT NULL,
    password VARCHAR(250) NOT NULL,
    phone_number BIGINT NOT NULL,
    address VARCHAR(500) NULL,
    country VARCHAR(100) NULL,
    state VARCHAR(100) NULL,
    zipcode INT NULL,
    role VARCHAR(25) NOT NULL
);

select * from user;
select user_id, first_name, last_name, email, password, phone_number from user where email = 'mathan@gmail.com';

select user_id from user where email = 'mathan@gmail.com';

CREATE TABLE IF NOT EXISTS orders (
	order_id INT PRIMARY KEY AUTO_INCREMENT,
	user_id int not null,
    payment_option VARCHAR(50) NOT NULL,
    total_price INT NOT NULL,
    ordered_date date not null,
    
    shipping_address VARCHAR(500) NOT NULL,
    country VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    zip_code INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);


select * from orders;

select * from orders where user_id = 4;

SELECT * FROM orders WHERE user_id = 1 ORDER BY order_id DESC LIMIT 1;



select orders.order_id, orders.user_id, orders.payment_option, orders.total_price, orders.ordered_date, ordered_products.ordered_product_id, 
ordered_products.product_id, ordered_products.quantity from orders inner join ordered_products on orders.order_id = ordered_products.order_id where user_id = 2;


CREATE TABLE IF NOT EXISTS ordered_products (
	ordered_product_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

select * from ordered_products;

select * from ordered_products where order_id = 1;

-- For Number of Count Sales Analytics Query
SELECT ordered_date, COUNT(order_id) 
FROM orders
GROUP BY ordered_date 
ORDER BY ordered_date DESC LIMIT 5;

-- Revenue Analytics Query
SELECT ordered_date, sum(total_price)
FROM orders
GROUP BY ordered_date
ORDER BY ordered_date DESC LIMIT 5;




