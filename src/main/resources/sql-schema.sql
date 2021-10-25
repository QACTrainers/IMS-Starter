DROP database ims;
CREATE database ims;

USE ims;

DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS order_line;

CREATE TABLE IF NOT EXISTS customers (
    id INT(11) NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(40) DEFAULT NULL,
    surname VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS items (id INT NOT NULL auto_increment, item_name VARCHAR(40) NOT NULL, value FLOAT DEFAULT NULL, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS orders (id INT NOT NULL auto_increment, customer_id INT NOT NULL, PRIMARY KEY(id), FOREIGN KEY(customer_id) REFERENCES customers(id));
CREATE TABLE IF NOT EXISTS order_line (id INT NOT NULL auto_increment, order_id INT NOT NULL, item_id INT NOT NULL, quantity INT default 1, PRIMARY KEY (id),FOREIGN KEY(order_id) REFERENCES orders(id),FOREIGN KEY(item_id) REFERENCES items(id)); 
