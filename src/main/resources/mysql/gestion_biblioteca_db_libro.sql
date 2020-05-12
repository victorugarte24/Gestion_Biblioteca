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
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro` (
  `Titulo` varchar(100) NOT NULL,
  `Autor` varchar(45) NOT NULL,
  `Paginas` int NOT NULL,
  `ISBN` int NOT NULL,
  `Sinopsis` varchar(1000) NOT NULL,
  `Prestado` int NOT NULL,
  `Genero` varchar(45) NOT NULL,
  `Editorial` varchar(45) NOT NULL,
  PRIMARY KEY (`Titulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES ('1793','Niklas Natt Och Dag',354,484841,'',1,'Thriller histórico','Salamandra'),('Croata','Jorge García García',304,43432342,'',1,'Novela negra','Amarante'),('Cronicas de la Torre','Laura Gallego Garcia',200,2000001,' ',1,'Fantástico','SM'),('El cuerpo humano','Bill Bryson',245,4343243,'',0,'Ciencias','RBA'),('El legado de los malditos','Vanesa Redondo',356,4342343,'',1,'Narrativa histórica','Salamandra'),('El senyor de los Anillos','J.R.R. Tolkien',300,2000000,' ',1,'Literatura fantástica','George Allen & Unwin'),('El silencio de la lengua','Luis Melero Marcos',298,434656,'',1,'Poética actual','Amarante'),('Il nome della rosa','Umberto Eco',256,777732,'',0,'Misterio','Destino'),('La cara norte del corazón','Dolores Redondo',304,564,'',0,'Suspense','Suma'),('La chica de nieve','Javier Castillo',348,584182,'',0,'Novela literaria','Suma'),('La madre de Frankenstein','Almudena Grandes',200,200001,'',1,'Misterio','Tusquets Editores'),('Loba negra','Juan Gómez-Jurado',275,4343,'',0,'Misterio','Ediciones B'),('Reina roja','Juan Gómez-Jurado',324,344324,'',0,'Tragedia','Ediciones B'),('Romeo y Julieta','William Shakespeare',150,1999999,' ',1,'Novela histórica','Espasa Calpe'),('Sidi','Arturo Pérez-Reverte',304,666,'',1,'Novela Rosa','Alfaguara'),('Un cuento perfecto','Elísabet Benavent',500,784844,'',1,'Fantasía','Suma'),('Y Julia retó a los dioses','Santiago Posteguillo',500,7848448,'',1,'Fantasía','Planeta');
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-10 18:57:22
