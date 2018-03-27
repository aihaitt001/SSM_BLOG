CREATE DATABASE  IF NOT EXISTS `ssm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ssm`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ssm
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `articles`
--

DROP TABLE IF EXISTS `articles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articles` (
  `articleId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `tags` varchar(100) DEFAULT NULL,
  `body` varchar(20000) DEFAULT NULL,
  `author` varchar(8) NOT NULL,
  `createtime` datetime NOT NULL,
  PRIMARY KEY (`articleId`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articles`
--

LOCK TABLES `articles` WRITE;
/*!40000 ALTER TABLE `articles` DISABLE KEYS */;
INSERT INTO `articles` VALUES (40,'Hello World!','test','请使用测试账户登陆系统，账号：test,密码：test','test','2018-03-14 16:39:16');
/*!40000 ALTER TABLE `articles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filesinfo`
--

DROP TABLE IF EXISTS `filesinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `filesinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(45) NOT NULL,
  `path` varchar(200) NOT NULL,
  `upuser` varchar(45) DEFAULT NULL,
  `uptime` datetime DEFAULT NULL,
  `isdelete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filesinfo`
--

LOCK TABLES `filesinfo` WRITE;
/*!40000 ALTER TABLE `filesinfo` DISABLE KEYS */;
INSERT INTO `filesinfo` VALUES (36,'RegistryLite.db','D:\\eclispeworkplace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\testshiro\\upload\\',NULL,NULL,0),(37,'1.txt','D:\\eclispeworkplace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\testshiro\\upload\\',NULL,NULL,0),(38,'druid后台密匙.txt','D:\\eclispeworkplace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\testshiro\\upload\\',NULL,NULL,0),(39,'修改.txt','D:\\eclispeworkplace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\testshiro\\upload\\',NULL,NULL,0),(40,'Notepad.java','D:\\eclispeworkplace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\testshiro\\upload\\',NULL,NULL,0),(41,'UniqueThing.java','D:\\eclispeworkplace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\testshiro\\upload\\',NULL,NULL,0),(42,'UniqueThing.java','D:\\eclispeworkplace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\testshiro\\upload\\',NULL,NULL,0),(43,'UniqueThing.java','D:\\eclispeworkplace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\testshiro\\upload\\',NULL,NULL,0),(44,'UniqueThing.java','D:\\eclispeworkplace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\testshiro\\upload\\',NULL,NULL,0),(45,'1.txt','D:\\eclispeworkplace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\testshiro\\upload\\',NULL,NULL,0),(46,'Notepad.java','D:\\eclispeworkplace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\testshiro\\upload\\',NULL,NULL,0),(47,'UniqueThing.java','D:\\eclispeworkplace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\testshiro\\upload\\',NULL,NULL,0),(48,'Notepad.java','D:\\eclispeworkplace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\testshiro\\upload\\',NULL,NULL,0),(49,'1. 利用redisres.md','D:\\eclispeworkplace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\testshiro\\upload\\',NULL,NULL,0),(50,'druid后台密匙.txt','D:\\eclispeworkplace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\testshiro\\upload\\',NULL,NULL,0);
/*!40000 ALTER TABLE `filesinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mycomments`
--

DROP TABLE IF EXISTS `mycomments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mycomments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentid` int(11) DEFAULT NULL,
  `body` varchar(200) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `committime` datetime DEFAULT NULL,
  `isdelete` varchar(2) DEFAULT '0',
  `istop` varchar(2) DEFAULT '0',
  `upnum` int(11) DEFAULT NULL,
  `downnum` int(11) DEFAULT NULL,
  `ps` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mycomments`
--

LOCK TABLES `mycomments` WRITE;
/*!40000 ALTER TABLE `mycomments` DISABLE KEYS */;
INSERT INTO `mycomments` VALUES (1,40,'评论测试',123,'2018-03-20 15:58:51','0','0',1,1,NULL);
/*!40000 ALTER TABLE `mycomments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin` int(1) NOT NULL,
  `username` varchar(16) NOT NULL,
  `email` varchar(30) DEFAULT 'null@email.com',
  `password` varchar(64) NOT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `salt` varchar(64) NOT NULL,
  `lastchange` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (123,2,'test','1061295856@qq.com','f02ffd7478b3a9a1c1a80f1382fd6cb5','2018-03-14 08:39:16','test7688c0c880ef4c58f1bd89f98eb1ccbb',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ssm'
--

--
-- Dumping routines for database 'ssm'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-27  9:00:32
