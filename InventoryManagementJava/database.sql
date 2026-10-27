CREATE DATABASE IF NOT EXISTS inventory_db;
USE inventory_db;

CREATE TABLE IF NOT EXISTS products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(120) NOT NULL,
    category VARCHAR(80) NOT NULL,
    quantity INT NOT NULL DEFAULT 0,
    price DECIMAL(10,2) NOT NULL,
    supplier VARCHAR(120),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_quantity_nonnegative CHECK (quantity >= 0),
    CONSTRAINT chk_price_nonnegative CHECK (price >= 0)
);

-- Optional sample data; uncomment if desired.
-- INSERT INTO products (product_name, category, quantity, price, supplier)
-- VALUES ('Notebook', 'Stationery', 40, 2.50, 'ABC Supplies');
