DROP SCHEMA `ims`;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR (40) DEFAULT NULL,
    `surname` VARCHAR (40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `item` (
	`item_id` INT NOT NULL AUTO_INCREMENT,
	`item_name` VARCHAR (40) DEFAULT NULL,
	`item_price` DOUBLE DEFAULT NULL,
	PRIMARY KEY (`item_id`)
);

CREATE TABLE IF NOT EXISTS `order` (
	`order_id` INT NOT NULL AUTO_INCREMENT,
	`fk_customer_id` INT NOT NULL,
	PRIMARY KEY (`order_id`),
	CONSTRAINT `fk_customer_id` FOREIGN KEY (`fk_customer_id`) REFERENCES `customers` (`id`)
);

CREATE TABLE IF NOT EXISTS `order_item` (
	`order_item_id` INT NOT NULL AUTO_INCREMENT, 
	`total_quantity` INT NOT NULL DEFAULT 1,
	`total_price` DOUBLE DEFAULT NULL,
	`fk_order_id` INT NOT NULL,
	`fk_item_id` INT NOT NULL,
	PRIMARY KEY (`order_item_id`),
	CONSTRAINT `fk_order_id` FOREIGN KEY (`fk_order_id`) REFERENCES `order` (`order_id`),
	CONSTRAINT `fk_item_id` FOREIGN KEY (`fk_item_id`) REFERENCES `item` (`item_id`)
    
);
