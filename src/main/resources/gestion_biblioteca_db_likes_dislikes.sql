-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: gestion_biblioteca_db
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `likes_dislikes`
--

DROP TABLE IF EXISTS `likes_dislikes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likes_dislikes` (
  `ID` int NOT NULL,
  `Titulo` varchar(45) DEFAULT NULL,
  `Likes` int DEFAULT NULL,
  `Dislikes` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Titulo_idx` (`Titulo`),
  CONSTRAINT `Titulo` FOREIGN KEY (`Titulo`) REFERENCES `libro` (`Titulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes_dislikes`
--

LOCK TABLES `likes_dislikes` WRITE;
/*!40000 ALTER TABLE `likes_dislikes` DISABLE KEYS */;
INSERT INTO `likes_dislikes` VALUES (0,'1793',34,5),(1,'Croata',43,5),(2,'Cronicas de la Torre',434,45),(3,'El cuerpo humano',45,45),(4,'El legado de los malditos',656,545),(5,'El senyor de los Anillos',775,45),(6,'El silencio de la lengua',56,1),(7,'Il nome della rosa',1,6),(8,'La cara norte del corazón',45,76),(9,'La chica de nieve',54,86),(10,'La madre de Frankenstein',4,5),(11,'Loba negra',54,656),(12,'Reina roja',454,23),(13,'Romeo y Julieta',7,6),(14,'Sidi',7,4),(15,'Un cuento perfecto',77,45),(16,'Y Julia retó a los dioses',74,67);
/*!40000 ALTER TABLE `likes_dislikes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-10 18:57:21
