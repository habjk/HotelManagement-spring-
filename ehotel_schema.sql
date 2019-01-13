-- Adminer 4.2.5 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `hotelId` bigint(20) NOT NULL,
  `hotelName` varchar(300) NOT NULL,
  `city` varchar(300) NOT NULL,
  `subCity` varchar(300) NOT NULL,
  `star` smallint(6) NOT NULL,
  `moto` text NOT NULL,
  `description` longtext NOT NULL,
  PRIMARY KEY (`hotelId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `roomId` bigint(20) NOT NULL,
  `floor` int(11) NOT NULL,
  `roomNumber` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `type` mediumtext NOT NULL,
  `description` text NOT NULL,
  `hotel` bigint(20) NOT NULL,
  PRIMARY KEY (`roomId`),
  KEY `hotel` (`hotel`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`hotel`) REFERENCES `hotel` (`hotelId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- 2019-01-11 13:22:55
