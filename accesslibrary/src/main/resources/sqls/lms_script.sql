-- -----------------------------------------------------
-- Library Management System
-- -----------------------------------------------------
DROP USER IF EXISTS 'lmsapp'@'localhost';

CREATE USER 'lmsapp'@'localhost' IDENTIFIED BY 'lmsapp';

GRANT ALL PRIVILEGES ON * . * TO 'lmsapp'@'localhost';

#
# Starting with MySQL 8.0.4, the MySQL team changed the 
# default authentication plugin for MySQL server 
# from mysql_native_password to caching_sha2_password.
#
# The command below will make the appropriate updates for your user account.
#
# See the MySQL Reference Manual for details: 
# https://dev.mysql.com/doc/refman/8.0/en/caching-sha2-pluggable-authentication.html
#
ALTER USER 'lmsapp'@'localhost' IDENTIFIED WITH mysql_native_password BY 'mysql007';

-- -----------------------------------------------------
-- Schema Library Management System
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `full-stack-lms`;

CREATE SCHEMA `full-stack-lms`;
USE `full-stack-lms` ;

-- -----------------------------------------------------
-- Table `book`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `t_book` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `isbn` VARCHAR(255) NOT NULL,
  `bar_code` VARCHAR(255) NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  `type` VARCHAR(255) NOT NULL,
  `subject` VARCHAR(255) DEFAULT NULL,
  `publisher` VARCHAR(255) DEFAULT NULL,
  `publication_date` DATE DEFAULT NULL,
  `book_language` VARCHAR(255) DEFAULT NULL,
  `number_of_pages` INT(11) DEFAULT NULL,
  `author` VARCHAR(255) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `genre` VARCHAR(255) DEFAULT NULL,
  `is_reference_only` VARCHAR(255) NOT NULL,
  `active` BIT DEFAULT 1,
  `units_in_lms` INT(11) NOT NULL,
  `rack_num` VARCHAR(255) NOT NULL,
  `date_created` DATETIME(6) NOT NULL,
  `last_updated` DATETIME(6) NOT NULL,
  `status` VARCHAR(255) NOT NULL,  
  PRIMARY KEY (`id`) 
) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Add sample data - `book`
-- -----------------------------------------------------
-- Science
INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
1, '1108469299', 100, 'Dinosaurs','BOOK','A Concise Natural History','Cambridge University Press','2021-08-05','ENGLISH','534', 'David E. Fastovsky', 'Paperback','SCIENCE', 0, 1, 
4, 'A01', NOW(), NOW(),'NEW');

INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
2, '1108456480', 101, 'An Introduction to Metamorphic Petrology','BOOK','Metamorphic Science','Cambridge University Press','2021-02-01','ENGLISH','344', 'Bruce Yardley', 'Paperback','SCIENCE', 
0, 1, 3, 'A01', NOW(), NOW(),'NEW');


INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
3, '9780134543536', 102, 'Earth Science','BOOK','Earth Science','Pearson','2017-08-31','ENGLISH','800', 'Tarbuck', 'Paperback','SCIENCE', 
0, 1, 6, 'A01', NOW(), NOW(),'NEW');


INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
4, '9781444333305', 103, 'Frontiers In Geofluids','BOOK','Earth Science','Wiley-Blackwell','2011-07-05','ENGLISH','328', 'Bruce Yardley', 'Paperback','SCIENCE', 
0, 1, 3, 'A01', NOW(), NOW(),'NEW');

--
INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
5, 'B00RKO0KWM', 104, 'Life On the Edge','BOOK','Natural Science','Crown','2015-07-28','ENGLISH','370', 'Johnjoe Mcfadden', 'Kindle','SCIENCE', 
0, 1, 3, 'A01', NOW(), NOW(),'NEW');

-- Technology

INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
6, 'B07L68H8B6', 105, 'Java Design Patterns','BOOK','A Hands-On Experience with Real-World Examples','Apress','2018-12-06','ENGLISH','538', 'Vaskaran Sarcar', 'Kindle','TECHNOLOGY', 
0, 1, 3, 'A02', NOW(), NOW(),'NEW');

INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
7, '1680507222', 106, 'A Common-Sense Guide to Data Structures and Algorithms','BOOK','Level Up Your Core Programming Skills','Apress','2020-09-01','ENGLISH','508', 'Jay Wengrow', 'Paperback','TECHNOLOGY', 
0, 1, 3, 'A02', NOW(), NOW(),'NEW');

INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
8, '1492041130', 107, 'Data Science from Scratch','BOOK','First Principles with Python','O Reilly Media','2019-09-16','ENGLISH','406', 'Joel Grus', 'Paperback','TECHNOLOGY', 
0, 1, 2, 'A02', NOW(), NOW(),'NEW');

INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
9, 'B078KMQQ88', 108, 'Database Systems','BOOK','Design, Implementation, & Management','Cengage Learning','2018-01-01','ENGLISH','816', 'Carlos Coronel', 'Kindle','TECHNOLOGY', 
0, 1, 2, 'A02', NOW(), NOW(),'NEW');

INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
10, 'B07T1Y2JRJ', 109, 'Hands-On Microservices with Spring Boot and Spring Cloud','BOOK','Build and deploy Java microservices using Spring Cloud, Istio, and Kubernetes','Packt Publishing','2019-09-20','ENGLISH','670', 'Magnus Larsson', 'Kindle','TECHNOLOGY', 
0, 1, 3, 'A02', NOW(), NOW(),'NEW');

-- Philosophy

INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
11, '9780062316110', 110, 'Sapiens','BOOK','A Brief History of Humankind','Harper','2015-02-10','ENGLISH','469', 'Yuval Noah Harari', 'Paperback','PHILOSOPHY', 
0, 1, 3, 'A03', NOW(), NOW(),'NEW');

INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
12, 'B08JVC1VB1', 111, 'Evolution Gone Wrong','BOOK','The Curious Reasons Why Our Bodies Work (Or Dont)','Hanover Square Press','2021-05-18','ENGLISH','362', 'Alex Bezzerides', 'Kindle','PHILOSOPHY', 
0, 1, 3, 'A03', NOW(), NOW(),'NEW');

INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
13, 'B01B7OIMOS', 112, 'Principles of Human Physiology','BOOK','6th Edition','Pearson','2016-01-19','ENGLISH','800', 'Cindy L. Stanfield', 'Kindle','PHILOSOPHY', 
0, 1, 3, 'A03', NOW(), NOW(),'NEW');

INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
14, '0262045435', 113, 'Neuroscience and Philosophy','BOOK','1st Edition','The MIT Press','2022-02-01','ENGLISH','506', 'Felipe De Brigard', 'Paperback','PHILOSOPHY', 
0, 1, 3, 'A03', NOW(), NOW(),'NEW');

INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
15, '0190207310', 114, 'Philosophy, Politics, and Economics','BOOK','An Anthology','Oxford University Press','2015-06-26','ENGLISH','672', 'Jonathan Anomaly', 'Paperback','PHILOSOPHY', 
0, 1, 3, 'A03', NOW(), NOW(),'NEW');

-- Autobiography

INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
16, 'B08GJZFBYV', 115, 'A Promised Land','BOOK','1st Edition','Crown','2020-11-17','ENGLISH','753', 'Barack Obama', 'Kindle','BIOGRAPHY', 
0, 1, 3, 'A04', NOW(), NOW(),'NEW');

INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
17, '0399590528', 116, 'Educated','BOOK','A Memoir','Random House Trade Paperbacks','2022-02-08','ENGLISH','368', 'Tara Westover', 'Paperback','BIOGRAPHY', 
0, 1, 3, 'A04', NOW(), NOW(),'NEW');

INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
18, '0876120834', 117, 'Autobiography of a Yogi','BOOK','Self-Realization Fellowship','Random House Trade Paperbacks','2000-01-01','ENGLISH','503', 'Paramahansa Yogananda', 'Paperback','BIOGRAPHY', 
0, 1, 3, 'A04', NOW(), NOW(),'NEW');

INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
19, 'B08F4GYK9P', 118, 'Karma','BOOK','A Yogis Guide to Crafting Your Destiny','Harmony','2000-01-01','ENGLISH','246', 'Sadhguru', 'Kindle','BIOGRAPHY', 
0, 1, 3, 'A04', NOW(), NOW(),'NEW');


INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
20, '0593139135', 119, 'Greenlights','BOOK','1st Edition','Crown','2020-10-20','ENGLISH','304', 'Matthew McConaughey', 'Hardcover','BIOGRAPHY', 
0, 1, 3, 'A04', NOW(), NOW(),'NEW');

-- Magazine

INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
21, '0013-0613', 120, 'The Economist','MAGAZINE','Current Edition','The Economist Group','2022-05-28','ENGLISH','10', 'Zanny Minton Beddoes', 'Weekly newspaper','NEWSPAPER', 
0, 1, 3, 'A05', NOW(), NOW(),'NEW');

INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
22, '0140-0460', 121, 'The Times','MAGAZINE','Current Edition','News UK','2022-05-28','ENGLISH','10', 'John Witherow', 'Daily newspaper','NEWSPAPER', 
0, 1, 3, 'A05', NOW(), NOW(),'NEW');

INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
23, '0099-9660', 122, 'The Wall Street Journal','MAGAZINE','Current Edition','News Corp','2022-05-28','ENGLISH','10', 'Charles Dow', 'Daily newspaper','NEWSPAPER', 
0, 1, 3, 'A05', NOW(), NOW(),'NEW');

INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
24, '0001-0001', 123, 'Outlook','MAGAZINE','Current Edition','Rajan Raheja Group','2022-05-28','ENGLISH','10', 'Chinki Sinha', 'Weekly magazine','NEWSMAGAZINE', 
0, 1, 3, 'A05', NOW(), NOW(),'NEW');

INSERT INTO t_book (id, isbn, bar_code, title, type, subject, publisher, publication_date, book_language,
number_of_pages, author, description, genre, is_reference_only, active, units_in_lms, rack_num, date_created, last_updated, status)
VALUES (
25, '0362-4331', 124, 'The New York Times','MAGAZINE','Current Edition','The New York Times Company','2022-05-28','ENGLISH','10', 'Dean Baquet', 'Daily newspaper','NEWSPAPER', 
0, 1, 3, 'A05', NOW(), NOW(),'NEW');


-- -----------------------------------------------------
-- Table t_address, t_account_user & t_book_item
-- -----------------------------------------------------
--
-- Prep work
--
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `t_address`;
DROP TABLE IF EXISTS `t_account_user`;
DROP TABLE IF EXISTS `t_book_item`;
SET FOREIGN_KEY_CHECKS=1;

-- -----------------------------------------------------
-- Table structure for table `t_address`
-- -----------------------------------------------------
CREATE TABLE `t_address` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table structure for table `t_account_user`
-- -----------------------------------------------------
CREATE TABLE `t_account_user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,  
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) NOT NULL,
  `membership_date` DATE DEFAULT NULL,
  `block_user` BIT DEFAULT 0 NOT NULL,  
  `total_fine` DECIMAL(13,2) DEFAULT NULL, 
  `fine_paid` DECIMAL(13,2) DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `address_id` bigint DEFAULT NULL,
  `num_books_checked_out` INT(11) NOT NULL, 
  `date_created` DATETIME(6) NOT NULL,
  `last_updated` DATETIME(6) NOT NULL,  
  PRIMARY KEY (`id`),
  CONSTRAINT `address_id` FOREIGN KEY (`address_id`) REFERENCES `t_address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Add sample data in t_address & t_account_user
-- -----------------------------------------------------
INSERT INTO t_address (id, city, country, state, street, zip_code)
VALUES (100, 'Bhawanipatna', 'India', 'Odisha','Radhakrushna Nagar','766001');

INSERT INTO t_address (id, city, country, state, street, zip_code)
VALUES (101, 'Balasore', 'India', 'Odisha','Soro','756045');

INSERT INTO t_address (id, city, country, state, street, zip_code)
VALUES (102, 'Albany', 'USA', 'New York','Guilderland','12084');


INSERT INTO t_account_user (id, name, email, phone, user_type, membership_date, block_user, total_fine,
fine_paid, status, address_id, num_books_checked_out, date_created, last_updated)
VALUES (1, 'Pragyan', 'pragyan@gmail.com', '5734620801','LIBRARIAN','2022-05-07',0,0.00,0.00,'ACTIVE',100,0,NOW(),NOW());

INSERT INTO t_account_user (id, name, email, phone, user_type, membership_date, block_user, total_fine,
fine_paid, status, address_id, num_books_checked_out, date_created, last_updated)
VALUES (2, 'Sabyasachi', 'sabyasachi@gmail.com', '5734626913','MEMBER','2022-05-07',0,0.00,0.00,'ACTIVE',101,0,NOW(),NOW());

INSERT INTO t_account_user (id, name, email, phone, user_type, membership_date, block_user, total_fine,
fine_paid, status, address_id, num_books_checked_out, date_created, last_updated)
VALUES (3, 'Aariketh', 'aariketh@gmail.com', '5734620802','MEMBER','2022-05-07',0,0.00,0.00,'ACTIVE',102,0,NOW(),NOW());

-- -----------------------------------------------------
-- Table structure for table `t_book_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `full-stack-lms`.`t_book_item` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `tracking_number` VARCHAR(255) DEFAULT NULL,   
  `borrowed_date` DATETIME(6) NOT NULL,
  `due_date` DATETIME(6) NOT NULL,  
  `book_status` VARCHAR(255) NOT NULL,
  `checkin_date` DATETIME(6) DEFAULT NULL,  
  `price` DECIMAL(13,2) DEFAULT NULL,  
  `active` BIT DEFAULT 1,  
  `date_created` DATETIME(6) NOT NULL,
  `last_updated` DATETIME(6) NOT NULL,
  `account_user_id` BIGINT(20) NOT NULL,
  `librarian_id` BIGINT(20) NOT NULL,
  `book_id` BIGINT(20) NOT NULL,
  `bar_code` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_account_user_id` (`account_user_id`),
  KEY `fk_book_id` (`book_id`),
  CONSTRAINT `fk_book_id` FOREIGN KEY (`book_id`) REFERENCES `t_book` (`id`)
) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;