use `rest-api-demo`;

drop table if exists `roles`;
drop table if exists `members`;


--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `members`;

CREATE TABLE `members` (
  `user_name` varchar(50) NOT NULL,
  `pw` char(80) NOT NULL,
  `enabled` tinyint NOT NULL,  
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `members` (`user_name`,`pw`,`enabled`)
VALUES 
('suvendu','{bcrypt}$2a$12$ajq4jglHE5G3WfHMJwLA/e7nN8/Z/t7x7jW9YTHIkrzFbGe3FLvju',1),
('sonali','{bcrypt}$2a$12$ajq4jglHE5G3WfHMJwLA/e7nN8/Z/t7x7jW9YTHIkrzFbGe3FLvju',1),
('nirmal','{bcrypt}$2a$12$ajq4jglHE5G3WfHMJwLA/e7nN8/Z/t7x7jW9YTHIkrzFbGe3FLvju',1);


--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `uname` varchar(50) NOT NULL,
  `role` varchar(50) DEFAULT NULL,
  foreign key(`uname`) references `members` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
insert into `roles` values
('suvendu','ROLE_ADMIN'),
('suvendu','ROLE_PUBLIC'),
('suvendu','ROLE_PRODUCER'),
('sonali','ROLE_PUBLIC'),
('sonali','ROLE_PRODUCER'),
('nirmal','ROLE_PUBLIC');
