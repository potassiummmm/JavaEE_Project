create database if not exists `JavaEE`;
use JavaEE;

drop table if exists `users`;
create table if not exists `users` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `nickname` char(30) DEFAULT NULL,
  `email` char(30) DEFAULT NULL,
  `password` char(30) DEFAULT NULL,
  `registrationTime` date NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `blogs`;
create table if not exists `blogs` (
  `blogId` int NOT NULL,
  `privateIndex` int NOT NULL,
  `authorId` int NOT NULL,
  `title` char(30) DEFAULT NULL,
  `content` varchar(300) DEFAULT NULL,
  `like` int NOT NULL,
  `view` int NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`blogId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `comments`;
create table if not exists `comments` (
  `blogId` int NOT NULL,
  `content` varchar(300) DEFAULT NULL,
  `senderId` char(30) DEFAULT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
