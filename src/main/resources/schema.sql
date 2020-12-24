create database if not exists `JavaEE`;
use JavaEE;

-- drop table if exists `users`;
create table if not exists `users` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `nickname` char(30) DEFAULT NULL,
  `email` char(30) DEFAULT NULL,
  `password` char(128) DEFAULT NULL,
  `registrationTime` timestamp NOT NULL,
  `userImage` mediumtext DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- drop table if exists `blogs`;
create table if not exists `blogs` (
    `blogId` int NOT NULL AUTO_INCREMENT,
    `privateIndex` int NOT NULL,
    `authorId` int NOT NULL,
     `authorNickname` char(30) DEFAULT NULL ,
    `title` char(30) DEFAULT NULL,
    `content` varchar(300) DEFAULT NULL,
    `like` int NOT NULL,
    `view` int NOT NULL,
    `star` int NOT NULL,
    `date` timestamp NOT NULL,
    PRIMARY KEY (`blogId`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- drop table if exists `comments`;
create table if not exists `comments` (
    `blogId` int NOT NULL,
    `content` varchar(300) DEFAULT NULL,
    `senderId` int NOT NULL,
    `senderNickname` char(30) DEFAULT NULL,
    `date` timestamp NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- drop table if exists `likes`;
create table if not exists `likes` (
    `userId` int NOT NULL,
    `nickname` varchar(30) DEFAULT NULL,
    `blogId` int NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- drop table if exists `stars`;
create table if not exists `stars` (
    `userId` int NOT NULL,
    `blogId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
