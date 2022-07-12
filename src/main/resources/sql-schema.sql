DROP SCHEMA `ims`;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

DROP TABLE `customer`;
DROP TABLE `item`;
DROP TABLE `order`;
DROP TABLE `order_item`;

CREATE TABLE IF NOT EXISTS `customer` (
    `customer_id` INT (11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR (40) DEFAULT NULL,
    `surname` VARCHAR (40) DEFAULT NULL,
    PRIMARY KEY (`customer_id`)
);

CREATE TABLE IF NOT EXISTS `item` (
	`item_id` INT (11) NOT NULL AUTO_INCREMENT,
	`item_name` VARCHAR (40) DEFAULT NULL,
	`item_price` DOUBLE DEFAULT NULL
	PRIMARY KEY (`item_id`)
);

CREATE TABLE IF NOT EXISTS `order` (
	`order_id` INT (11) NOT NULL AUTO_INCREMENT,
	`order_placed` DATE DEFAULT NULL,
	`fk_customer_id` INT NOT NULL,
	PRIMARY KEY (`order_id`),
	CONSTRAINT `fk_customer_id` FOREIGN KEY (`fk_customer_id`) REFERENCES customers (`customer_id`)
);

CREATE TABLE IF NOT EXISTS `order_item` (
	`order_item_id` INT (11) NOT NULL AUTO_INCREMENT,
	`total_price` DOUBLE DEFAULT NULL,
	`fk_order_id` INT NOT NULL,
	`fk_item_id` INT NOT NULL,
	PRIMARY KEY (`order_item_id`),
	CONSTRAINT `fk_order_id` FOREIGN KEY (`fk_order_id`) REFERENCES `order` (`order_id`),
	CONSTRAINT `fk_item_id` FOREIGN KEY (`fk_item_id`) REFERENCES `item` (`item_id`)
);


