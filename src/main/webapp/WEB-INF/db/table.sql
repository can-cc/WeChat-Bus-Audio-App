CREATE TABLE `audio` (
  `name` varchar(100) NOT NULL,
  `filename` varchar(100) NOT NULL,
  `categoryid` int(11) NOT NULL,
  `playtime` int(11) DEFAULT NULL,
  `bitrate` int(11) DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `description` text,
  `authority` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`name`,`categoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `dirPath` varchar(200) NOT NULL,
  `coverPath` varchar(200) DEFAULT NULL,
  `description` text,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `authority` int(11) DEFAULT NULL,
  PRIMARY KEY (`categoryId`),
  UNIQUE KEY `categoryId_UNIQUE,name_UNIQUE` (`categoryId`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8

