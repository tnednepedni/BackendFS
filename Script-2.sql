CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(255),
    phone VARCHAR(20)
);
CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE flash_sales (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE flash_sale_products (
    id SERIAL PRIMARY KEY,
    flash_sale_id INT REFERENCES flash_sales(id),
    product_id INT REFERENCES products(id),
    sale_price DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    max_per_user INT DEFAULT 2,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    flash_sale_product_id INT REFERENCES flash_sale_products(id),
    quantity INT NOT NULL,
    status VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE INDEX idx_orders_user_product
ON orders(user_id, flash_sale_product_id);

CREATE INDEX idx_flash_sale_product
ON flash_sale_products(product_id);

INSERT INTO users(username,email,password)
VALUES ('bao123','bao@gmail.com','123456');

INSERT INTO products(name,price)VALUES 
('Samsung S23', 18000000),
('Xiaomi 13', 12000000),
('Macbook Air M2', 30000000),
('Ipad Pro 11', 25000000),
('Sony WH-1000XM5', 9000000);
('Iphone 15',20000000);

INSERT INTO flash_sales(name,start_time,end_time)
VALUES ('Flash Sale 3.3', NOW(), NOW() + INTERVAL '1 hour');

INSERT INTO flash_sale_products(flash_sale_id,product_id,sale_price,stock,max_per_user)VALUES 
(1,2,9000000,20,2),
(1,3,6000000,15,2),
(1,4,22000000,5,1),
(1,5,18000000,8,1),
(1,6,5000000,30,3);
(1,1,10000000,10,2);

SELECT * FROM flash_sale_products;

SELECT p.name, fsp.*
FROM flash_sale_products fsp
JOIN products p ON p.id = fsp.product_id;

