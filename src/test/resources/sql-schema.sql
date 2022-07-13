-- DROP DATABASE ims;

CREATE DATABASE IF NOT EXISTS ims;
USE ims;

CREATE TABLE IF NOT EXISTS customers
(
    id         INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(40) DEFAULT NULL,
    surname    VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS items
(
    items_id    INT           NOT NULL AUTO_INCREMENT,
    items_name  VARCHAR(40)   NOT NULL,
    items_price DECIMAL(7, 2) NOT NULL,
    PRIMARY KEY (items_id)
);

CREATE TABLE IF NOT EXISTS orders
(
    orders_id          INT           NOT NULL AUTO_INCREMENT,
    orders_total_price DECIMAL(7, 2) NOT NULL,
    fk_customers_id    INT           NOT NULL,
    PRIMARY KEY (orders_id),
    FOREIGN KEY (fk_customers_id) REFERENCES customers (id)
);

CREATE TABLE IF NOT EXISTS orders_items
(
    fk_orders_id INT NOT NULL,
    fk_items_id  INT NOT NULL,
    FOREIGN KEY (fk_orders_id) REFERENCES orders (orders_id),
    FOREIGN KEY (fk_items_id) REFERENCES items (items_id)
);
