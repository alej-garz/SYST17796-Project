CREATE TABLE menu_items (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price FLOAT NOT NULL,
    category VARCHAR(50),
    available BOOLEAN DEFAULT TRUE
);

CREATE TABLE inventory_items (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    quantity INTEGER NOT NULL,
    unit VARCHAR(20),
    price_per_unit FLOAT
);

CREATE TABLE orders (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    inventory_item_id INTEGER,
    quantity_to_order INTEGER NOT NULL,
    order_date DATE DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20),
    FOREIGN KEY (inventory_item_id) REFERENCES inventory_items(id)
);

INSERT INTO menu_items (name, description, price, category, available) VALUES
('Garlic Bread', 'Toasted bread with garlic and herbs', 5.50, 'APETIZER', TRUE),
('Caesar Salad', 'Fresh romaine lettuce with Caesar dressing', 8.99, 'APETIZER', TRUE),
('Spaghetti Carbonara', 'Classic pasta with creamy sauce, bacon, and cheese', 14.99, 'MAIN_COURSE', TRUE),
('Grilled Chicken Breast', 'Juicy chicken breast with vegetables', 18.50, 'MAIN_COURSE', TRUE),
('Chocolate Lava Cake', 'Warm chocolate cake with a gooey center', 7.99, 'DESSERT', TRUE),
('Cheesecake', 'Creamy cheesecake with a graham cracker crust', 6.99, 'DESSERT', TRUE),
('Coca-Cola', 'Chilled Coca-Cola can', 2.50, 'DRINKS', TRUE),
('Orange Juice', 'Freshly squeezed orange juice', 3.00, 'DRINKS', TRUE),
('Margarita Pizza', 'Classic pizza with tomato, cheese, and basil', 12.99, 'MAIN_COURSE', TRUE),
('French Fries', 'Crispy french fries with ketchup', 4.50, 'APETIZER', TRUE),
('Tiramisu', 'Layered dessert with coffee and mascarpone', 6.50, 'DESSERT', TRUE),
('Espresso', 'Strong coffee shot', 2.00, 'DRINKS', TRUE);
