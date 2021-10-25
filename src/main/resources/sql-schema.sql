drop schema ims;

CREATE SCHEMA IF NOT EXISTS ims;

USE ims ;

CREATE TABLE IF NOT EXISTS ims.customers (
    id INT(11) NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(40) DEFAULT NULL,
    surname VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS items (id INT NOT NULL auto_increment, item_name VARCHAR(40) NOT NULL, value FLOAT DEFAULT NULL, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS orders (id INT NOT NULL auto_increment, customer_id INT NOT NULL, PRIMARY KEY(id));
CREATE TABLE IF NOT EXISTS order_line (id INT NOT NULL auto_increment, order_id INT NOT NULL, item_id VARCHAR(40) NOT NULL, quantity INT default 1, PRIMARY KEY (id)); 
