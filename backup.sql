-- MySQL dump 10.13  Distrib 5.5.48, for Linux (x86_64)
--
-- Host: localhost    Database: ali_asp
-- ------------------------------------------------------
-- Server version	5.5.48

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
-- Table structure for table `Comment`
--

DROP TABLE IF EXISTS `Comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Comment` (
  `Comment_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Comment_Content` varchar(200) COLLATE utf8_turkish_ci NOT NULL,
  `Comment_Author` int(11) NOT NULL,
  `Comment_Emoji` int(11) DEFAULT NULL,
  `Comment_CreateDate` datetime NOT NULL,
  `Comment_Point` int(11) DEFAULT NULL,
  `Comment_Editable` tinyint(1) DEFAULT NULL,
  `Comment_POSTID` int(11) DEFAULT NULL,
  PRIMARY KEY (`Comment_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Comment`
--

LOCK TABLES `Comment` WRITE;
/*!40000 ALTER TABLE `Comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `Comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Emoji`
--

DROP TABLE IF EXISTS `Emoji`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Emoji` (
  `Emoji_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Emoji_Title` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `Emoji_IconUrl` varchar(200) COLLATE utf8_turkish_ci DEFAULT NULL,
  `Emoji_Point` int(11) DEFAULT NULL,
  `Emoji_Editable` tinyint(1) DEFAULT NULL,
  KEY `Emoji_ID` (`Emoji_ID`),
  KEY `Emoji_ID_2` (`Emoji_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Emoji`
--

LOCK TABLES `Emoji` WRITE;
/*!40000 ALTER TABLE `Emoji` DISABLE KEYS */;
/*!40000 ALTER TABLE `Emoji` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Messagess`
--

DROP TABLE IF EXISTS `Messagess`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Messagess` (
  `msgID` int(11) NOT NULL AUTO_INCREMENT,
  `takenID` int(11) NOT NULL,
  `senderID` int(11) NOT NULL,
  `msgcontent` varchar(200) COLLATE utf8_turkish_ci DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  KEY `Messagess_msgID_IDX` (`msgID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Messagess`
--

LOCK TABLES `Messagess` WRITE;
/*!40000 ALTER TABLE `Messagess` DISABLE KEYS */;
/*!40000 ALTER TABLE `Messagess` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Post`
--

DROP TABLE IF EXISTS `Post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Post` (
  `Post_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Post_Title` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `Post_CreateDate` datetime NOT NULL,
  `Post_Point` int(11) DEFAULT NULL,
  `Post_Content` varchar(200) COLLATE utf8_turkish_ci DEFAULT NULL,
  `Post_Emoji` int(11) DEFAULT NULL,
  `Post_Auther` int(11) NOT NULL,
  UNIQUE KEY `Post_Id` (`Post_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Post`
--

LOCK TABLES `Post` WRITE;
/*!40000 ALTER TABLE `Post` DISABLE KEYS */;
INSERT INTO `Post` VALUES (6,'ilk baslık','2016-04-14 06:07:35',0,'merhaba dunya',0,6),(7,'ilk baslik','2016-04-14 06:14:56',0,'merhaba dunya',0,6),(8,'baslik','2016-04-14 06:35:31',0,'içerik',0,6),(16,'denemebasl?k','2016-05-09 14:31:03',NULL,'içerik',NULL,9);
/*!40000 ALTER TABLE `Post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User_Data`
--

DROP TABLE IF EXISTS `User_Data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User_Data` (
  `User_Id` int(11) NOT NULL AUTO_INCREMENT,
  `User_FirstName` varchar(30) DEFAULT NULL,
  `User_LastName` varchar(30) DEFAULT NULL,
  `User_Email` varchar(50) NOT NULL,
  `User_Sifre` varchar(30) DEFAULT NULL,
  `User_NickName` varchar(30) DEFAULT NULL,
  `User_Point` int(11) DEFAULT NULL,
  `Date_of_Birth` date DEFAULT NULL,
  `Use_Permission` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`User_Id`),
  UNIQUE KEY `User_Email` (`User_Email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_Data`
--

LOCK TABLES `User_Data` WRITE;
/*!40000 ALTER TABLE `User_Data` DISABLE KEYS */;
INSERT INTO `User_Data` VALUES (5,NULL,NULL,'alikemal@gmail.com','23456','alikemalocalan',NULL,NULL,0),(6,NULL,NULL,'alikemalocalan@gmail.com','234','ali',NULL,NULL,1),(7,'ali',NULL,'ali@gmail.com','123456','alikemal',0,NULL,0),(9,'murat',NULL,'murat@goyimdeturat.com',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `User_Data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-09 18:11:10
