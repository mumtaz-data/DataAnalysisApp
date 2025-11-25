-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: library_db
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `book_id` text,
  `title` text,
  `author` text,
  `genre` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES ('B001','Book_Title_1','Lucy Khan','Fiction'),('B002','Book_Title_2','Linda Mugambi','Science'),('B003','Book_Title_3','Brian Mugambi','Non-fiction'),('B004','Book_Title_4','Jane Ali','Non-fiction'),('B005','Book_Title_5','Jane Otieno','Fiction'),('B006','Book_Title_6','Carlos Smith','Science'),('B007','Book_Title_7','Aisha Khan','Fiction'),('B008','Book_Title_8','Mary Karanja','Non-fiction'),('B009','Book_Title_9','Amira Wei','Non-fiction'),('B010','Book_Title_10','Lucy Murithi','Science'),('B011','Book_Title_11','Jane Khan','Science'),('B012','Book_Title_12','Aisha Otieno','History'),('B013','Book_Title_13','Ali Karanja','Fiction'),('B014','Book_Title_14','Chen Ouma','Non-fiction'),('B015','Book_Title_15','Mary Muli','Science'),('B016','Book_Title_16','Sara Karanja','Non-fiction'),('B017','Book_Title_17','Omar Kim','Fiction'),('B018','Book_Title_18','Mary Murithi','Fiction'),('B019','Book_Title_19','Mark Njoroge','Science'),('B020','Book_Title_20','Sam Njoroge','Science'),('B021','Book_Title_21','Tom Achieng','Science'),('B022','Book_Title_22','Carlos Njoroge','History'),('B023','Book_Title_23','Sara Ouma','History'),('B024','Book_Title_24','Amira Njoroge','Non-fiction'),('B025','Book_Title_25','Omar Wei','Non-fiction'),('B026','Book_Title_26','John Wang','Fiction'),('B027','Book_Title_27','Lucy Wang','Non-fiction'),('B028','Book_Title_28','Brian Karanja','History'),('B029','Book_Title_29','Jane Mwangi','Science'),('B030','Book_Title_30','Paul Kim','Fiction');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-05 13:46:08
