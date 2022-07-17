--INSERT INTO `customer` (`first_name`, `surname`) VALUES ('jordan', 'harrison');

--INSERT INTO `Item` (`itemName`, `price`) VALUES ('calculator', '9.99');

--INSERT INTO `Orders` (`customerID`, `date`) VALUES ('1', '2022-07-14');

INSERT INTO `Orderline` (`fk_orderID`, `fk_itemID`, `quantity`) VALUES ('1', '1', '20');