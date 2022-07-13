drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `items` (
	`item_id` INT(8) NOT NULL AUTO_INCREMENT,
	`item_name` VARCHAR(40) NULL DEFAULT NULL,
	`item_price` DOUBLE NULL DEFAULT NULL,
	PRIMARY KEY (`item_id`)
	);
	
	
CREATE TABLE IF NOT EXISTS `orders` (
	`order_id` INT(8) UNIQUE NOT NULL AUTO_INCREMENT,
	`fk_customer_id` INT NOT NULL,
	`fk_item_id` INT NOT NULL,
	PRIMARY KEY (`order_id`),
	CONSTRAINT `fk_customer_id` FOREIGN KEY (`fk_customer_id`) REFERENCES customers (`id`),
	CONSTRAINT `fk_item_id` FOREIGN KEY (`fk_item_id`) REFERENCES items (`item_id`)
	);
	
CREATE TABLE IF NOT EXISTS `order_items` (
	`order_item_id` INT (8) UNIQUE NOT NULL AUTO_INCREMENT,
	`unit_price` DOUBLE NOT NULL,
	`item_name` VARCHAR (55) NOT NULL,
	`unit_quantity` INT NOT NULL DEFAULT 1,
	`fk_order_id` INT NOT NULL,
	`fk2_item_id` INT NOT NULL,
	`fk2_customer_id` INT NOT NULL,
	PRIMARY KEY (`order_item_id`),
	CONSTRAINT `fk_order_id` FOREIGN KEY (`fk_order_id`) REFERENCES `orders` (`order_id`),
	CONSTRAINT `fk2_item_id` FOREIGN KEY (`fk2_item_id`) REFERENCES `items` (`item_id`),
	CONSTRAINT `fk2_customer_id` FOREIGN KEY (`fk2_customer_id`) REFERENCES `customers` (`id`)
	);