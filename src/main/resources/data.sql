-- Insert additional menu items
INSERT INTO menu_items (name, description, price, category, available) VALUES
('Bruschetta', 'Grilled bread topped with fresh tomatoes, basil, and olive oil', 6.50, 'APPETIZER', TRUE),
('Stuffed Mushrooms', 'Mushrooms filled with cheese, herbs, and breadcrumbs', 7.00, 'APPETIZER', TRUE),
('Beef Steak', 'Grilled beef steak served with garlic butter and vegetables', 22.99, 'MAIN_COURSE', TRUE),
('Seafood Paella', 'Traditional Spanish rice dish with assorted seafood and saffron', 19.99, 'MAIN_COURSE', TRUE),
('Vegetable Stir-fry', 'Mixed vegetables stir-fried in soy sauce with a hint of ginger', 13.50, 'MAIN_COURSE', TRUE),
('Shrimp Scampi', 'Shrimp cooked in garlic butter sauce served over linguine', 17.99, 'MAIN_COURSE', TRUE),
('Garlic Shrimp', 'Shrimp sautéed with garlic, herbs, and lemon juice', 16.50, 'MAIN_COURSE', TRUE),
('Caprese Salad', 'Fresh mozzarella, tomatoes, and basil drizzled with balsamic glaze', 9.50, 'APPETIZER', TRUE),
('Minestrone Soup', 'Hearty Italian vegetable soup with beans and pasta', 6.75, 'APPETIZER', TRUE),
('BBQ Ribs', 'Tender ribs smothered in smoky barbecue sauce', 20.50, 'MAIN_COURSE', TRUE),
('Cheese Platter', 'Assorted cheeses served with crackers and fresh fruit', 12.00, 'APPETIZER', TRUE),
('Chocolate Mousse', 'Light and airy chocolate dessert topped with whipped cream', 5.50, 'DESSERT', TRUE),
('Apple Pie', 'Classic apple pie with a flaky crust and cinnamon', 5.99, 'DESSERT', TRUE),
('Ice Cream Sundae', 'Vanilla ice cream topped with chocolate syrup, nuts, and a cherry', 4.50, 'DESSERT', TRUE),
('Panna Cotta', 'Creamy Italian dessert with a berry coulis', 5.75, 'DESSERT', TRUE),
('Lemonade', 'Freshly squeezed lemonade with a hint of mint', 2.99, 'DRINKS', TRUE),
('Iced Tea', 'Refreshing iced black tea with lemon', 2.50, 'DRINKS', TRUE),
('Smoothie', 'Blend of fresh fruits and yogurt', 3.99, 'DRINKS', TRUE),
('Hot Chocolate', 'Rich and creamy hot chocolate topped with marshmallows', 2.75, 'DRINKS', TRUE),
('Espresso Martini', 'Classic cocktail with espresso, vodka, and coffee liqueur', 8.50, 'DRINKS', TRUE),
('Margarita Pizza', 'Classic pizza with tomato, mozzarella, and fresh basil', 12.99, 'MAIN_COURSE', TRUE),
('French Fries', 'Crispy french fries served with ketchup or mayo', 4.50, 'APPETIZER', TRUE),
('Tiramisu', 'Layered dessert with coffee-soaked ladyfingers and mascarpone cream', 6.50, 'DESSERT', TRUE),
('Coca-Cola', 'Chilled Coca-Cola can', 2.50, 'DRINKS', TRUE),
('Orange Juice', 'Freshly squeezed orange juice', 3.00, 'DRINKS', TRUE),
('Chocolate Lava Cake', 'Warm chocolate cake with a gooey center', 7.99, 'DESSERT', TRUE),
('Cheesecake', 'Creamy cheesecake with a graham cracker crust', 6.99, 'DESSERT', TRUE);


-- Insert inventory items
INSERT INTO inventory_items (name, quantity, unit, price_per_unit) VALUES
-- Produce
('Tomatoes', 100, 'KG', 2.20),
('Lettuce', 150, 'KG', 1.80),
('Onions', 200, 'KG', 1.00),
('Potatoes', 300, 'KG', 0.80),
('Garlic', 50, 'KG', 3.00),
('Carrots', 120, 'KG', 1.20),
('Spinach', 80, 'KG', 2.00),
('Mushrooms', 90, 'KG', 4.00),
('Bell Peppers', 100, 'KG', 2.50),
('Cucumbers', 70, 'KG', 1.50),
('Eggplant', 60, 'KG', 1.70),
('Zucchini', 75, 'KG', 1.60),
('Basil', 15, 'KG', 15.00),
('Cilantro', 10, 'KG', 10.00),
('Parsley', 10, 'KG', 10.00),

-- Dairy
('Milk', 200, 'LITERS', 1.20),
('Butter', 50, 'KG', 5.50),
('Cheddar Cheese', 40, 'KG', 6.00),
('Mozzarella Cheese', 60, 'KG', 7.00),
('Cream Cheese', 25, 'KG', 4.80),
('Yogurt', 100, 'LITERS', 1.50),
('Eggs', 1000, 'PIECES', 0.20),
('Sour Cream', 30, 'KG', 3.50),

-- Meat
('Chicken Breast', 150, 'KG', 7.00),
('Ground Beef', 120, 'KG', 8.50),
('Bacon', 80, 'KG', 9.00),
('Sausages', 100, 'KG', 7.50),
('Turkey', 30, 'KG', 10.00),
('Lamb Chops', 20, 'KG', 15.00),
('Ribeye Steak', 40, 'KG', 18.00),
('Pork Shoulder', 60, 'KG', 6.00),

-- Seafood
('Salmon', 50, 'KG', 14.00),
('Shrimp', 80, 'KG', 12.00),
('Lobster', 20, 'KG', 20.00),
('Crab', 30, 'KG', 18.00),
('Tuna', 45, 'KG', 16.00),
('Squid', 40, 'KG', 10.00),
('Oysters', 60, 'PIECES', 1.50),

-- Grains and Bread
('Bread Loaves', 100, 'PIECES', 2.00),
('Rice', 200, 'KG', 1.10),
('Pasta', 180, 'KG', 1.50),
('Flour', 250, 'KG', 0.90),
('Quinoa', 80, 'KG', 5.00),
('Tortillas', 150, 'PIECES', 0.50),

-- Beverages
('Orange Juice', 100, 'LITERS', 3.00),
('Apple Juice', 90, 'LITERS', 2.80),
('Coca-Cola', 200, 'LITERS', 0.80),
('Mineral Water', 300, 'LITERS', 0.50),
('Red Wine', 50, 'LITERS', 12.00),
('White Wine', 50, 'LITERS', 10.00),
('Coffee Beans', 30, 'KG', 20.00),
('Tea Leaves', 25, 'KG', 18.00),

-- Condiments and Spices
('Salt', 100, 'KG', 0.50),
('Pepper', 50, 'KG', 8.00),
('Olive Oil', 60, 'LITERS', 5.00),
('Vinegar', 80, 'LITERS', 3.00),
('Ketchup', 100, 'KG', 1.00),
('Mustard', 60, 'KG', 1.20),
('Soy Sauce', 90, 'LITERS', 2.50),
('Chili Powder', 20, 'KG', 10.00),
('Oregano', 15, 'KG', 12.00),
('Paprika', 20, 'KG', 9.00),
('Cinnamon', 10, 'KG', 15.00),
('Cumin', 10, 'KG', 14.00),
('Turmeric', 15, 'KG', 13.00),

-- Frozen Items
('Frozen Peas', 100, 'KG', 1.80),
('Frozen Corn', 80, 'KG', 1.70),
('Ice Cream', 60, 'LITERS', 4.00),
('Frozen Berries', 70, 'KG', 5.00),
('Frozen Pizza Dough', 50, 'PIECES', 2.50),

-- Baking Supplies
('Sugar', 150, 'KG', 1.10),
('Brown Sugar', 100, 'KG', 1.30),
('Baking Powder', 20, 'KG', 2.50),
('Yeast', 15, 'KG', 3.00),
('Cocoa Powder', 25, 'KG', 7.00),
('Vanilla Extract', 10, 'LITERS', 25.00),
('Chocolate Chips', 30, 'KG', 6.50),

-- Miscellaneous
('Toothpicks', 2000, 'PIECES', 0.01),
('Napkins', 500, 'PIECES', 0.05),
('Straws', 1000, 'PIECES', 0.02),
('Aluminum Foil', 100, 'ROLLS', 2.00),
('Plastic Wrap', 80, 'ROLLS', 1.50),
('Paper Towels', 120, 'ROLLS', 1.20);



-- Insert orders
INSERT INTO orders (inventory_item_id, quantity_to_order, order_date, status) VALUES
(1, 5, '2024-11-01', 'Pending'),
(2, 10, '2024-11-02', 'Completed'),
(3, 3, '2024-11-03', 'Cancelled'),
(4, 7, '2024-11-04', 'Pending'),
(5, 15, '2024-11-05', 'Completed'),
(6, 20, '2024-11-06', 'Pending'),
(7, 8, '2024-11-07', 'Completed'),
(8, 12, '2024-11-08', 'Cancelled'),
(9, 1, '2024-11-09', 'Pending'),
(10, 25, '2024-11-10', 'Completed'),
(11, 5, '2024-11-11', 'Pending'),
(12, 2, '2024-11-12', 'Cancelled'),
(1, 6, '2024-11-13', 'Pending'),
(2, 9, '2024-11-14', 'Completed'),
(3, 13, '2024-11-15', 'Pending'),
(4, 4, '2024-11-16', 'Completed'),
(5, 18, '2024-11-17', 'Cancelled'),
(6, 22, '2024-11-18', 'Pending'),
(7, 3, '2024-11-19', 'Completed'),
(8, 17, '2024-11-20', 'Pending');

