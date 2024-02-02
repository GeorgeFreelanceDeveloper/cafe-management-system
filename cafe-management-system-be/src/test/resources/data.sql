-- Users
INSERT INTO "user" (contact_number,email,name,password,`role`,status) VALUES
	 ('1234567819','admin@mailnator.com','Admin','12345','admin','true'),
	 ('1234567890','user@mailnator.com','User','12345','user','true');

-- Categories
INSERT INTO `category` (`name`) VALUES
('Cafe'),
('Pizza'),
('Meals'),
('Pasta'),
('Beverages'),
('Desserts'),
('Salads'),
('Bakery'),
('Sandwiches'),
('Snacks');

-- Cafe products
INSERT INTO `product` (`name`, `description`, `price`, `status`, `category_id`) VALUES
('Espresso', 'Strong black coffee', 3, 'Available', 1),
('Cappuccino', 'Espresso with steamed milk and foam', 4, 'Available', 1),
('Latte', 'Espresso with a lot of steamed milk and a little foam', 4, 'Available', 1),
('Mocha', 'Espresso with chocolate and steamed milk', 5, 'Available', 1),
('Americano', 'Espresso with hot water', 3, 'Available', 1),
('Macchiato', 'Espresso with a dollop of frothy milk', 4, 'Available', 1),
('Iced Coffee', 'Chilled coffee served with ice', 4, 'Available', 1),
('Caramel Macchiato', 'Espresso with caramel and milk', 5, 'Available', 1),
('Vanilla Latte', 'Espresso with vanilla syrup and milk', 5, 'Available', 1),
('Double Espresso', 'Two shots of strong black coffee', 4, 'Available', 1);

-- Pizza products
INSERT INTO `product` (`name`, `description`, `price`, `status`, `category_id`) VALUES
('Margherita Pizza', 'Classic pizza with tomato and mozzarella', 8, 'Available', 2),
('Pepperoni Pizza', 'Pizza with pepperoni and cheese', 9, 'Available', 2),
('Vegetarian Pizza', 'Pizza with assorted vegetables', 7, 'Available', 2),
('Hawaiian Pizza', 'Pizza with ham and pineapple', 9, 'Available', 2),
('Supreme Pizza', 'Pizza with various toppings', 10, 'Available', 2),
('Margarita Pizza', 'Pizza with tomato, mozzarella, and basil', 8, 'Available', 2),
('BBQ Chicken Pizza', 'Pizza with BBQ chicken and onions', 9, 'Available', 2),
('Buffalo Chicken Pizza', 'Pizza with buffalo chicken and ranch dressing', 9, 'Available', 2),
('Pesto Pizza', 'Pizza with pesto sauce and pine nuts', 8, 'Available', 2),
('Calzone', 'Folded pizza with various fillings', 8, 'Available', 2);

-- Meals products
INSERT INTO `product` (`name`, `description`, `price`, `status`, `category_id`) VALUES
('Chicken Alfredo', 'Creamy pasta with chicken', 11, 'Available', 3),
('Spaghetti Carbonara', 'Spaghetti with eggs, cheese, and pancetta', 10, 'Available', 3),
('Beef Stroganoff', 'Beef in a creamy mushroom sauce', 12, 'Available', 3),
('Grilled Salmon', 'Salmon fillet with lemon butter', 13, 'Available', 3),
('Vegetable Stir-Fry', 'Mixed vegetables in a savory sauce', 9, 'Available', 3),
('Mushroom Risotto', 'Risotto with mushrooms and Parmesan', 10, 'Available', 3),
('Pork Chop', 'Grilled pork chop with apple sauce', 11, 'Available', 3),
('Beef Tacos', 'Tacos with seasoned beef and toppings', 9, 'Available', 3),
('Chicken Parmesan', 'Breaded chicken with marinara and cheese', 12, 'Available', 3),
('Veggie Burger', 'Vegetarian burger with all the fixings', 8, 'Available', 3);

-- Pasta products
INSERT INTO `product` (`name`, `description`, `price`, `status`, `category_id`) VALUES
('Spaghetti Carbonara', 'Spaghetti with eggs, cheese, and pancetta', 10, 'Available', 4),
('Mushroom Risotto', 'Risotto with mushrooms and Parmesan', 11, 'Available', 4),
('Penne alla Vodka', 'Penne pasta in a creamy tomato sauce', 10, 'Available', 4),
('Fettuccine Alfredo', 'Fettuccine pasta in a creamy sauce', 9, 'Available', 4),
('Linguine with Clams', 'Linguine pasta with garlic and clams', 12, 'Available', 4),
('Lasagna', 'Layered pasta with meat and cheese', 13, 'Available', 4),
('Spaghetti Bolognese', 'Spaghetti with meat sauce', 11, 'Available', 4),
('Vegetable Pasta Primavera', 'Pasta with seasonal vegetables', 9, 'Available', 4),
('Lobster Ravioli', 'Ravioli with lobster filling and sauce', 14, 'Available', 4),
('Pesto Linguine', 'Linguine with basil and pine nut pesto', 10, 'Available', 4);

-- Beverages products
INSERT INTO `product` (`name`, `description`, `price`, `status`, `category_id`) VALUES
('Iced Tea', 'Chilled black or green tea', 3, 'Available', 5),
('Lemonade', 'Freshly squeezed lemon juice with sugar', 4, 'Available', 5),
('Soda', 'Carbonated soft drinks', 2, 'Available', 5),
('Orange Juice', 'Freshly squeezed orange juice', 5, 'Available', 5),
('Iced Coffee', 'Chilled coffee served with ice', 4, 'Available', 5),
('Hot Chocolate', 'Hot cocoa with whipped cream', 4, 'Available', 5),
('Milkshake', 'Thick and creamy milkshake', 5, 'Available', 5),
('Smoothie', 'Blended fruit and yogurt drink', 6, 'Available', 5),
('Water', 'Bottled or tap water', 1, 'Available', 5),
('Cocktail', 'Alcoholic mixed drink', 7, 'Available', 5);

-- Desserts products
INSERT INTO `product` (`name`, `description`, `price`, `status`, `category_id`) VALUES
('Chocolate Cake', 'Rich and moist chocolate cake', 4, 'Available', 6),
('Cheesecake', 'Creamy and sweet cheesecake', 5, 'Available', 6),
('Apple Pie', 'Traditional American apple pie', 5, 'Available', 6),
('Tiramisu', 'Italian dessert with coffee and mascarpone', 6, 'Available', 6),
('Ice Cream Sundae', 'Ice cream with toppings and whipped cream', 5, 'Available', 6),
('Fruit Salad', 'Assorted fresh fruits', 4, 'Available', 6),
('Molten Chocolate Cake', 'Warm chocolate cake with a liquid center', 6, 'Available', 6),
('Creme Brulee', 'Custard with a caramelized sugar top', 7, 'Available', 6),
('Panna Cotta', 'Italian dessert with cream and fruit', 6, 'Available', 6),
('Red Velvet Cake', 'Classic red velvet cake with cream cheese frosting', 5, 'Available', 6);

-- Salads products
INSERT INTO `product` (`name`, `description`, `price`, `status`, `category_id`) VALUES
('Caesar Salad', 'Romaine lettuce, croutons, and Caesar dressing', 6, 'Available', 7),
('Greek Salad', 'Mixed greens, olives, feta cheese, and dressing', 7, 'Available', 7),
('Caprese Salad', 'Tomato, mozzarella, basil, and balsamic dressing', 6, 'Available', 7),
('Cobb Salad', 'Mixed greens, bacon, avocado, and blue cheese', 8, 'Available', 7),
('Spinach Salad', 'Baby spinach with bacon and vinaigrette', 6, 'Available', 7),
('Waldorf Salad', 'Apples, celery, walnuts, and mayonnaise', 7, 'Available', 7),
('Chicken Caesar Salad', 'Caesar salad with grilled chicken', 8, 'Available', 7),
('Nicoise Salad', 'Salad with tuna, olives, eggs, and dressing', 9, 'Available', 7),
('Asian Chicken Salad', 'Mixed greens with chicken and sesame dressing', 8, 'Available', 7),
('Mediterranean Salad', 'Mixed greens, olives, and feta with lemon dressing', 7, 'Available', 7);

-- Bakery products
INSERT INTO `product` (`name`, `description`, `price`, `status`, `category_id`) VALUES
('Baguette', 'French bread with a crispy crust', 3, 'Available', 8),
('Croissant', 'Buttery and flaky pastry', 2, 'Available', 8),
('Sourdough Bread', 'Rustic bread with a tangy flavor', 4, 'Available', 8),
('Cinnamon Roll', 'Sweet roll with cinnamon and icing', 3, 'Available', 8),
('Chocolate Croissant', 'Croissant with chocolate filling', 3, 'Available', 8),
('Blueberry Muffin', 'Muffin with blueberries and crumb topping', 2, 'Available', 8),
('Pretzel', 'Soft and salted pretzel', 2, 'Available', 8),
('Apple Turnover', 'Pastry filled with spiced apples', 3, 'Available', 8),
('Eclair', 'Pastry filled with cream and topped with chocolate', 4, 'Available', 8),
('Bagel', 'Ring-shaped bread roll', 2, 'Available', 8);

-- Sandwiches products
INSERT INTO `product` (`name`, `description`, `price`, `status`, `category_id`) VALUES
('Turkey Sandwich', 'Sandwich with turkey and fresh vegetables', 6, 'Available', 9),
('BLT Sandwich', 'Bacon, lettuce, and tomato sandwich', 5, 'Available', 9),
('Chicken Club Sandwich', 'Chicken, bacon, and lettuce on toast', 7, 'Available', 9),
('Vegetarian Wrap', 'Wrap with mixed vegetables and hummus', 6, 'Available', 9),
('Tuna Salad Sandwich', 'Tuna salad with lettuce on bread', 6, 'Available', 9),
('Reuben Sandwich', 'Corned beef, sauerkraut, and Swiss cheese on rye', 7, 'Available', 9),
('Grilled Cheese Sandwich', 'Melted cheese between slices of bread', 5, 'Available', 9),
('Ham and Cheese Croissant', 'Croissant with ham and cheese', 5, 'Available', 9),
('Philly Cheesesteak', 'Steak, onions, and cheese on a roll', 8, 'Available', 9),
('Cuban Sandwich', 'Roast pork, ham, and pickles on Cuban bread', 7, 'Available', 9);


-- Snacks products
INSERT INTO `product` (`name`, `description`, `price`, `status`, `category_id`) VALUES
('Potato Chips', 'Classic potato chips', 2, 'Available', 10),
('Pretzels', 'Salted pretzels', 2, 'Available', 10),
('Popcorn', 'Buttered and salted popcorn', 3, 'Available', 10),
('Trail Mix', 'Mix of nuts, seeds, and dried fruits', 4, 'Available', 10),
('Candy Bar', 'Chocolate and candy bar', 2, 'Available', 10),
('Nuts', 'Assorted nuts, roasted and salted', 4, 'Available', 10),
('Crackers', 'Variety of crackers', 3, 'Available', 10),
('Gummy Bears', 'Assorted gummy bears', 2, 'Available', 10),
('Granola Bars', 'Bars with oats, nuts, and dried fruits', 3, 'Available', 10),
('Rice Cakes', 'Crispy rice cakes', 2, 'Available', 10);