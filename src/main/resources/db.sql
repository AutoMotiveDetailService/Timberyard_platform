CREATE DATABASE  IF NOT EXISTS `timber_yard`;
USE `timber_yard`;
--
-- Table structure for table `role`
--\--- Create office table
DROP TABLE IF EXISTS `office`;
CREATE TABLE `office` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `office_name` varchar(200) NOT NULL,
  `propritor_name` varchar(50) NOT NULL,
  `licence_number` varchar(50) NOT NULL,
  `licence_issueDate` varchar(50) DEFAULT NULL,
  `term_number` BIGINT(20) DEFAULT NULL,
  `prefix_name` varchar(200) DEFAULT NULL,
  `lot_number` varchar(200) DEFAULT NULL,
  `address` varchar(2000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
INSERT INTO `role` VALUES (1,'ROLE_USER');
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `office_id` BIGINT,
  PRIMARY KEY (`id`),
  KEY `fk_user_office_idx` (`office_id`),
  CONSTRAINT `fk_user_office_idx` FOREIGN KEY (`office_id`) REFERENCES `office` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` BIGINT(11) NOT NULL,
  `role_id` BIGINT(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_user_role_roleid_idx` (`role_id`),
  CONSTRAINT `fk_user_role_roleid` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_role_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;