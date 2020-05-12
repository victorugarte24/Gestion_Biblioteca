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
-- Table structure for table `libro_ubicacion`
--

DROP TABLE IF EXISTS `libro_ubicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro_ubicacion` (
  `Ubicacion` varchar(100) NOT NULL,
  `Libro` varchar(45) DEFAULT NULL,
  KEY `Libro_idx` (`Libro`),
  CONSTRAINT `Libro` FOREIGN KEY (`Libro`) REFERENCES `libro` (`Titulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro_ubicacion`
--

LOCK TABLES `libro_ubicacion` WRITE;
/*!40000 ALTER TABLE `libro_ubicacion` DISABLE KEYS */;
INSERT INTO `libro_ubicacion` VALUES ('Planta 3 Pasillo 1 Estanteria 4','1793'),('Planta 4 Pasillo 5 Estanteria 3','Croata'),('Planta 1 Pasillo 3 Estanteria 3','Cronicas de la Torre'),('Planta 3 Pasillo 2 Estanteria 1','El cuerpo humano'),('Planta 1 Pasillo 4 Estanteria 3','El legado de los malditos'),('Planta 2 Pasillo 7 Estanteria 2','El senyor de los Anillos'),('Planta 1 Pasillo 4 Estanteria 5','El silencio de la lengua'),('Planta 4 Pasillo 2 Estanteria 6','La cara norte del corazón'),('Planta 4 Pasillo 9 Estanteria 6','La chica de nieve'),('Planta 1 Pasillo 8 Estanteria 5','Loba negra'),('Planta 3 Pasillo 8 Estanteria 5','Reina roja'),('Planta 3 Pasillo 8 Estanteria 4','Romeo y Julieta'),('Planta 3 Pasillo 7 Estanteria 4','Sidi'),('Planta 5 Pasillo 7 Estanteria 3','Un cuento perfecto'),('Planta 5 Pasillo 7 Estanteria 3','Y Julia retó a los dioses'),('Planta 5 Pasillo 1 Estanteria 8','La madre de Frankenstein'),('Planta 2 Pasillo 1 Estanteria 5','Il nome della rosa');
/*!40000 ALTER TABLE `libro_ubicacion` ENABLE KEYS */;
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
