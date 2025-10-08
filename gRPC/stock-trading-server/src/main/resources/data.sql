-- Create table
CREATE TABLE stocks (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        stock_symbol VARCHAR(10) UNIQUE NOT NULL,
                        price DOUBLE PRECISION NOT NULL,
                        last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Insert initial data
INSERT INTO stocks (stock_symbol, price) VALUES ('AAPL', 175.50);
INSERT INTO stocks (stock_symbol, price) VALUES ('GOOGL', 2800.75);
INSERT INTO stocks (stock_symbol, price) VALUES ('AMZN', 3400.00);

-- Alter table to add currency column
ALTER TABLE stocks
    ADD COLUMN currency VARCHAR(3) NOT NULL DEFAULT 'USD';
