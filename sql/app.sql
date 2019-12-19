CREATE TABLE `app` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_name` varchar(50) DEFAULT NULL,
  `app_info` varchar(50) DEFAULT NULL,
  `app_key` varchar(50) DEFAULT NULL,
  `creater_id` int(11) DEFAULT NULL,
  `creater_time` datetime DEFAULT NULL,
  `updater_id` int(11) DEFAULT NULL,
  `updater_time` datetime DEFAULT NULL,
  `is_delete` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;