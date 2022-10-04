drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE If NOT EXISTS ims.orders (
    order_ID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fk_customer_ID INT(11) NOT NULL,
    placed DATE NOT NULL,
    total INT(120) NOT NULL,
    FOREIGN KEY (fk_customer_ID) REFERENCES customers(id)
);

CREATE TABLE if NOT EXISTS ims.items (
    item_ID INT (11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    item_name VARCHAR(49) NOT NULL,
    item_value INT(50) NOT NULL,
    quantity INT(50) NOT NULL,
    colour VARCHAR(15) NOT NULL
);

CREATE TABLE if NOT EXISTS ims.order_item (
    order_item_ID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fk_order_ID INT(11) NOT NULL,
    fk_item_ID INT(11) NOT NULL,
    quantity INT(50) NOT NULL,
    total INT (120) NOT NULL,
    FOREIGN KEY (fk_item_ID) REFERENCES items(`item_ID`),
    FOREIGN KEY (fk_order_ID) REFERENCES orders(`order_ID`)
);
