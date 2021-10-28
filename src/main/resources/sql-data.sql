INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `ims`.`items` (`id`, `item_name`, `value`) VALUES (`1`, `ps5`, `500.25`);
INSERT INTO `ims`.`orders` (`id`, `customer_id`) VALUES (`1`,`1`);
INSERT INTO `ims`.`order_line` (`id`, `order_id`, `item_id`, `quantity`) VALUES (`1`, `1`, `8`);