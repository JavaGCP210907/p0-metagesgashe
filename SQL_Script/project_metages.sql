CREATE TABLE customers (
	customer_id serial PRIMARY KEY,
	f_name TEXT NOT NULL, 
	l_name TEXT NOT NULL,
	street_number TEXT NOT NULL, 
	city TEXT NOT NULL,
	state char(2) NOT NULL,
	zip_code char(5) NOT NULL
	
);

CREATE TABLE products (
	product_id serial PRIMARY KEY,
	product_name TEXT NOT NULL, 
	price decimal (6, 2), 
	delivery_status TEXT,
	customer_id int REFERENCES customers(customer_id)
);



INSERT INTO customers (f_name, l_name, street_number, city, state, zip_code)
VALUES ('John', 'Smith', '123 Dennis avenue', 'Silver Spring', 'MD', 20901),
	   ('Alexa', 'David', '234 Georgia avenu', 'DC', 'DC', 20902),
	   ('Adam', 'Johnathan', '345 1st street', 'New york city', 'NY', 28321),
	   ('Abrham', 'Solomon', '568 2nd street', 'Los Angeles', 'CA', 32562);
	   
	  
INSERT INTO products (product_name, price, delivery_status, customer_id)
VALUES ('HP', 1249.99, 'Information recieved', 1),
       ('LG', 1499, 'Out for delivery', 2),
       ('Dell', 849, 'Delivered', 1),
       ('Mac', 1899.99, 'Pending', 3),
       ('Lenovo', 1789, 'Failed attempt', 4);
      
insert into products (product_name, price, delivery_status, customer_id) values ()
       
SELECT * FROM customers c LEFT JOIN products p ON c.customer_id = p.customer_id;

select p.product_name, p.price, c.f_name, c.l_name from products p join customers c on p.customer_id = c.customer_id where c.f_name='John';

--SELECT concat(f_name, ' ', l_name) AS "Full Name", concat(Street_number, ', ', city, ', ', state, ' ', zip_code) AS "Address"  FROM customers;

SELECT * FROM products;
SELECT * FROM customers;


