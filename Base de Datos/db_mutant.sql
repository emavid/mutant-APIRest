/*
SQLyog Ultimate v9.63 
MySQL - 5.5.5-10.4.11-MariaDB : Database - db_mutant
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_mutant` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `db_mutant`;

/*Table structure for table `mutant` */

DROP TABLE IF EXISTS `mutant`;

CREATE TABLE `mutant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dna` tinyblob DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `mutant` */

insert  into `mutant`(`id`,`dna`) values (1,'¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0ATGCGAt\0CAGTGCt\0TTATGTt\0AGAAGGt\0CCCCTAt\0TCACTG');

/*Table structure for table `revision_info` */

DROP TABLE IF EXISTS `revision_info`;

CREATE TABLE `revision_info` (
  `id` int(11) NOT NULL,
  `revision_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `revision_info` */

/*Table structure for table `seq_revision_id` */

DROP TABLE IF EXISTS `seq_revision_id`;

CREATE TABLE `seq_revision_id` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `seq_revision_id` */

insert  into `seq_revision_id`(`next_val`) values (1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
