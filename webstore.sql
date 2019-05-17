use jpa;

==================================================================================================================

 CREATE TABLE `storeProducts` (
   `productId` int NOT NULL AUTO_INCREMENT,
   `name` varchar(250) NOT NULL,
   `unitPrice` DECIMAL NOT NULL,
   `description` varchar(1000) NOT NULL,
   `manufacturer` varchar(100) NOT NULL,
   `category` varchar(100) NOT NULL,
   `unitsInStock` DECIMAL NOT NULL,
   `unitsInOrder` DECIMAL NOT NULL,
   `discontinued` BIT NOT NULL,
   `conditionProduct` varchar(250) NOT NULL,
   PRIMARY KEY (`productId`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 

 insert into storeProducts (`productId`, `name`, `unitPrice`, `description`, `manufacturer`, `category`, `unitsInStock`, `unitsInOrder`, `discontinued`, `condition` ) values (
 1234, 'iPhone 5s', 500, 'Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera',
  'Apple', 'Smart Phone', 1000, 0, 0, 1);
 
  insert into storeProducts (`productId`, `name`, `unitPrice`, `description`, `manufacturer`, `category`, `unitsInStock`, `unitsInOrder`, `discontinued`, `condition` ) values (
 1235, 'Dell Inspirons', 700, 'Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors',
  'Dell', 'Laptop', 1000, 0, 0, 1);

  insert into storeProducts (`productId`, `name`, `unitPrice`, `description`, `manufacturer`, `category`, `unitsInStock`, `unitsInOrder`, `discontinued`, `condition` ) values (
 1236, 'Dell Inspirons', 700, 'Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm SnapdragonTM S4 Pro processor',
  'Nexus', 'Tablet', 1000, 0, 0, 1);

==================================================================================================================

CREATE TABLE `clients` (
  `customerId` varchar(250) NOT NULL,
  `name` varchar(250) NOT NULL,
  `address` varchar(500) NOT NULL,
  `noOfOrdersMade` DECIMAL NOT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into clients ( `customerId`, `name`, `address`, `noOfOrdersMade`) values (
'Jan1234', 'Jan Kowalski', 'Lusńska Bydgoszcz', 6);

insert into clients ( `customerId`, `name`, `address`, `noOfOrdersMade`) values (
'Stefan1234', 'Stefan Kowalski', 'Lusńska Warszawa', 10);

insert into clients ( `customerId`, `name`, `address`, `noOfOrdersMade`) values (
'Maciek1234', 'Maciek Kowalski', 'Melonowska Bydgoszcz', 100);
==================================================================================================================

CREATE TABLE `authorized` (
  `username` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `role` varchar(250) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO jpa.authorized
(username, password, `role`) VALUES('admin', 'admin12345', 'ADMIN');

INSERT INTO jpa.authorized
(username, password, `role`) VALUES('user', 'user12345', 'USER');


select * from jpa.authorized


==================================================================================================================


--for old testing
--CREATE TABLE `cartitem` (
--  `cartId` varchar(250) NOT NULL,
--  `grandTotal` DECIMAL NOT NULL,
--  PRIMARY KEY (`cartId`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--SELECT * FROM jpa.cartitem;

--INSERT INTO jpa.cartitem (`cartId`, `grandTotal`) VALUES ('P12', 1)
