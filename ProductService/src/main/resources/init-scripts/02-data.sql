INSERT INTO products (name, price)
SELECT * FROM (VALUES
    ('Laptop', 1200.00),
    ('Smartphone', 799.99),
    ('Tablet', 450.00),
    ('Monitor', 199.99),
    ('Keyboard', 49.99)
) AS tmp(name, price)
WHERE NOT EXISTS (SELECT 1 FROM products);