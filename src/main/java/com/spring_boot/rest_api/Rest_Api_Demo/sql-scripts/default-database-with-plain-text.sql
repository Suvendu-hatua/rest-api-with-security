use `rest-api-demo`;

drop table if exists `authorities`;
drop table if exists `users`;


--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  `enabled` tinyint NOT NULL,  
  PRIMARY KEY (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `users` (`username`,`password`,`enabled`)
VALUES 
('suvendu','{noop}test@123',1),
('sonali','{noop}test@123',1),
('nirmal','{noop}test@123',1);


--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) DEFAULT NULL,
  foreign key(`username`) references `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
insert into `authorities` values
('suvendu','ROLE_ADMIN'),
('suvendu','ROLE_PUBLIC'),
('suvendu','ROLE_PRODUCER'),
('sonali','ROLE_PUBLIC'),
('sonali','ROLE_PRODUCER'),
('nirmal','ROLE_PUBLIC');
