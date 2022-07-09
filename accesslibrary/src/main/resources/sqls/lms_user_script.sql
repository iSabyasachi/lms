-- -----------------------------------------------------
-- Table structure for table `users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `full-stack-lms`.`users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `enabled` INT NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table structure for table `authorities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `full-stack-lms`.`authorities` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `authority` varchar(45) NOT NULL, 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Add sample data in users & authorities
-- -----------------------------------------------------
INSERT INTO `full-stack-lms`.`users`(`username`,`password`,`enabled`) VALUES ('sabyasachi','1234','1');
INSERT INTO `full-stack-lms`.`authorities`(`username`,`authority`) VALUES ('sabyasachi','write');

