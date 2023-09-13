Use mathankumar_nagarajan_corejava_project;

-- Store Table Details
CREATE TABLE IF NOT EXISTS stores(
	store_id int primary key AUTO_INCREMENT,
    store_name VARCHAR (75) NOT NULL,
    category VARCHAR (50) NOT NULL,
    store_logo blob NOT NULL
    );
    
-- Product Table Detaisl
CREATE TABLE IF NOT EXISTS products (
	product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_title VARCHAR(500) NOT NULL,
    product_price DOUBLE NOT NULL,
    product_image BLOB NOT NULL,
    uploaded_date DATE NOT NULL,
    store_id INT NOT NULL,
    foreign key(store_id) references stores (store_id)
);


-- User Table Details
CREATE TABLE IF NOT EXISTS user(
	user_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR (100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(200) NOT NULL,
    password VARCHAR(20) NOT NULL,
    phone_number BIGINT NOT NULL
);


-- Orders Table Details
CREATE TABLE IF NOT EXISTS orders (
	order_id INT PRIMARY KEY AUTO_INCREMENT,
	user_id int not null,
    payment_status VARCHAR(10) NOT NULL,
    total_price INT NOT NULL,
    ordered_date date not null,
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);


-- Ordered Product Table Details
CREATE TABLE IF NOT EXISTS ordered_products (
	ordered_product_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

