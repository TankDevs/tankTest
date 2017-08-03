CREATE DATABASE  IF NOT EXISTS `zlh_test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `zlh_test`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: zlh_test
-- ------------------------------------------------------
-- Server version	5.6.35-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aaa`
--

DROP TABLE IF EXISTS `aaa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aaa` (
  `idaaa` int(11) NOT NULL,
  PRIMARY KEY (`idaaa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aaa`
--

LOCK TABLES `aaa` WRITE;
/*!40000 ALTER TABLE `aaa` DISABLE KEYS */;
/*!40000 ALTER TABLE `aaa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `departmentId` int(11) NOT NULL COMMENT '科室ID',
  `name` varchar(45) NOT NULL COMMENT '科室名称',
  `address` varchar(50) NOT NULL COMMENT '科室位置',
  PRIMARY KEY (`departmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='科室表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (10001,'眼科','二楼201'),(10002,'耳鼻喉科','三楼308');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `roleId` int(11) NOT NULL,
  `roleDescription` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'管理员'),(2,'操作员');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` varchar(100) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `departmentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `FK_user_role_idx` (`roleId`),
  KEY `FK_user_depart_idx` (`departmentId`),
  CONSTRAINT `FK_user_depart` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_user_role` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='user for test';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('a44ww;\' DROP TABLE zlh_test.aaa;\'',NULL,NULL,'dd',NULL,NULL),('admin','小明',30,'123456',1,10001),('admin;drop table aaa',NULL,NULL,'dd',NULL,NULL),('admins',NULL,NULL,'123456',NULL,NULL),('ass; DROP TABLE zlh_test.aaa;',NULL,NULL,'ddd',NULL,NULL),('ddda; DROP TABLE zlh_test.aaa;',NULL,NULL,'ddd',NULL,NULL),('zhangsan','张三',20,'123456',2,10001);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-26 13:49:05
