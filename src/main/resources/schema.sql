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

CREATE TABLE reviews (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    author VARCHAR(50) NOT NULL,
    description VARCHAR(255),
    rating VARCHAR(10) NOT NULL
);

