create database if not exists `JavaEE`;
use JavaEE;
create table if not exists `user` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `nickname` char(30) DEFAULT NULL,
  `email` char(30) DEFAULT NULL,
  `password` char(30) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;