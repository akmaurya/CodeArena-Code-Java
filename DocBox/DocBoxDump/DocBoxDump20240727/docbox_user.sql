-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: docbox
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'arvind@gmail.com','$2a$10$0GZ1f9dJ7le29gEhUN1s8.bVzGi3IkI.4YdOEKZ4UrViACR37wPFu','arvind'),(2,'khushboo@example.com','$2a$10$JOOlaJF6Pv4on6PYJmCNAu9.N5/G.A7AN21w.yaJQlGE8/WZBWdPu','khushboo'),(3,'khushboomaurya1905@gmail.com','$2a$10$Vw9If1r4Emv7GD/GKreHe.qv/MSFVEQiKgvdsBsTk8X/MApHKrBZO','Khushboo maurya '),(4,'rajatkumarmaury@gmail.com','$2a$10$8bHpG5TliLltzwo87jOEdeU/rx/H/3YCs.fkpGyO/cjwpWT8Uc77a','Rajat'),(5,'rajat2@gmail.com','$2a$10$2T68UnIhBtDE8kzw2L0EcuqAC6i1D2HlOfAw1GN21GvZNQrSqnr/O','rajat2'),(6,'rajat3','$2a$10$9D2jEUR/Qp7vm7QMA99tAuYIhgPJJ6g5fTTaV20VLXrrbAIqEl4QK','rajat3'),(7,'arvind2@gmail.com','$2a$10$XlU0jKxWNdK65yw.GVWm4eADMmTbgjznkQjePuG61l1dV6yiMnpfO','arvind2'),(8,'arvind3@gmail.com','$2a$10$AuqLXX//zdKp3Gaxkas5xejgT/7Cj0JNCy8sajmZt.MF0cC4vW73u','arvind3'),(87,'rajatkumarmaurya@gmail.com','$2a$10$QYKU37kOqfvnN3MylJG5HOyJHcTMCRijdnI0Hzj.zAlvCGCwono1y','rajatkumarmaurya'),(88,'arvindmaurya1905101@gmail.com','$2a$10$HnQyDRYsR1bD0tku2X2O2.otvMAOpUzJ1Hx9ExORJ6qZ0mUhcy01O','kmauryA'),(89,'arvindmaurya1905102@gmail.com','$2a$10$xHIIhjrcl0pRaDziY2rDrekTHzhdWbXosn.afYutzw.AqCGx2W6fW','ArvindKumarMaurya'),(100,'amit@gmail.com','$2a$10$Y4LkHcObZxh5.2xmEY1kKOpPf33I1RMYyXwVHKf7xzFlGH8YhQUa2','Amit'),(105,'pagli@gamil.com','password','pagli');
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

-- Dump completed on 2024-07-27 23:38:57
