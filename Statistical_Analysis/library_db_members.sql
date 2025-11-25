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
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `members` (
  `member_id` text,
  `first_name` text,
  `last_name` text,
  `email` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members`
--

LOCK TABLES `members` WRITE;
/*!40000 ALTER TABLE `members` DISABLE KEYS */;
INSERT INTO `members` VALUES ('M001','James','Smith','james1@library.com'),('M002','David','Wei','david2@library.com'),('M003','Lucy','Ndegwa','lucy3@library.com'),('M004','Chen','Wei','chen4@library.com'),('M005','Lucy','Ali','lucy5@library.com'),('M006','Sam','Wei','sam6@library.com'),('M007','Brian','Smith','brian7@library.com'),('M008','Omar','Achieng','omar8@library.com'),('M009','Carlos','Mworia','carlos9@library.com'),('M010','Fatima','Mworia','fatima10@library.com'),('M011','Ali','Achieng','ali11@library.com'),('M012','Mary','Ali','mary12@library.com'),('M013','James','Murithi','james13@library.com'),('M014','Omar','Mugambi','omar14@library.com'),('M015','Carlos','Ndegwa','carlos15@library.com'),('M016','Sam','Mwangi','sam16@library.com'),('M017','Lucy','Doe','lucy17@library.com'),('M018','Amira','Mworia','amira18@library.com'),('M019','Njeri','Kim','njeri19@library.com'),('M020','Lucy','Khan','lucy20@library.com'),('M021','Tom','Mwangi','tom21@library.com'),('M022','Omar','Ali','omar22@library.com'),('M023','Omar','Wang','omar23@library.com'),('M024','Ali','Wang','ali24@library.com'),('M025','Omar','Mworia','omar25@library.com'),('M026','Fatima','Otieno','fatima26@library.com'),('M027','Ali','Achieng','ali27@library.com'),('M028','Omar','Ndegwa','omar28@library.com'),('M029','Ruth','Achieng','ruth29@library.com'),('M030','Brian','Ali','brian30@library.com'),('M031','Grace','Mugambi','grace31@library.com'),('M032','Grace','Smith','grace32@library.com'),('M033','James','Ali','james33@library.com'),('M034','Aisha','Murithi','aisha34@library.com'),('M035','Kim','Ruiz','kim35@library.com'),('M036','Amira','Ruiz','amira36@library.com'),('M037','Amira','Smith','amira37@library.com'),('M038','Sam','Wei','sam38@library.com'),('M039','Chen','Mworia','chen39@library.com'),('M040','Chen','Ali','chen40@library.com'),('M041','Mary','Ruiz','mary41@library.com'),('M042','David','Doe','david42@library.com'),('M043','Brian','Muli','brian43@library.com'),('M044','John','Mworia','john44@library.com'),('M045','Mark','Ouma','mark45@library.com'),('M046','Paul','Doe','paul46@library.com'),('M047','Brian','Ouma','brian47@library.com'),('M048','Linda','Kim','linda48@library.com'),('M049','Njeri','Ouma','njeri49@library.com'),('M050','Lucy','Karanja','lucy50@library.com');
/*!40000 ALTER TABLE `members` ENABLE KEYS */;
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
