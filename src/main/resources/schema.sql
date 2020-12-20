create database if not exists `JavaEE`;
use JavaEE;

create table if not exists `users` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `nickname` char(30) DEFAULT NULL,
  `email` char(30) DEFAULT NULL,
  `password` char(30) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table if not exists `blogs` (
  `blogId` int NOT NULL,
  `title` char(30) DEFAULT NULL,
  `content` varchar(300) DEFAULT NULL,
  `author` char(30) DEFAULT NULL,
  `like` int NOT NULL,
  `view` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table if not exists `comments` (
  `blogId` int NOT NULL,
  `content` varchar(300) DEFAULT NULL,
  `senderId` char(30) DEFAULT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;