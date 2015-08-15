CREATE DATABASE  IF NOT EXISTS `shop` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `shop`;
-- MySQL dump 10.13  Distrib 5.6.22, for osx10.8 (x86_64)
--
-- Host: 127.0.0.1    Database: shop
-- ------------------------------------------------------
-- Server version	5.6.15

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
-- Table structure for table `carrinho`
--

DROP TABLE IF EXISTS `carrinho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrinho` (
  `idCarrinho` int(11) NOT NULL AUTO_INCREMENT,
  `sessao` varchar(256) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idCarrinho`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrinho`
--

LOCK TABLES `carrinho` WRITE;
/*!40000 ALTER TABLE `carrinho` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrinho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `idCompra` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) NOT NULL,
  `tipo` varchar(15) NOT NULL,
  `cartao` varchar(20) NOT NULL,
  `cod` varchar(3) NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`idCompra`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `idItem` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(3) NOT NULL,
  `descricao` varchar(80) NOT NULL,
  `valor` float NOT NULL,
  `imagem` varchar(30) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `idCarrinho` int(11) DEFAULT NULL,
  PRIMARY KEY (`idItem`),
  KEY `FkItemDoCarrinho` (`idCarrinho`),
  CONSTRAINT `FkItemDoCarrinho` FOREIGN KEY (`idCarrinho`) REFERENCES `carrinho` (`idCarrinho`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemdecompra`
--

DROP TABLE IF EXISTS `itemdecompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemdecompra` (
  `iditemDeCompra` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(3) NOT NULL,
  `descricao` varchar(80) NOT NULL,
  `valor` float NOT NULL,
  `imagem` varchar(30) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `idCompra` int(11) DEFAULT NULL,
  PRIMARY KEY (`iditemDeCompra`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemdecompra`
--

LOCK TABLES `itemdecompra` WRITE;
/*!40000 ALTER TABLE `itemdecompra` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemdecompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `idProduto` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(3) NOT NULL,
  `descricao` varchar(80) NOT NULL,
  `valor` float NOT NULL,
  `imagem` varchar(30) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `reservado` int(11) DEFAULT '0',
  PRIMARY KEY (`idProduto`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'001','CPU Core 2 Duo E4600 2GB 500GB DVDRW Linux Qbex + LCD 20\" Wide AOC',1499,'imagens/cpu.jpg',8,0),(2,'002','Vencedor Está Só, O - PAULO COELHO',31.9,'imagens/livro2.jpg',5,0),(3,'003','Refrigerador Duplex Frost Free BRM47AR Inox Brastemp',2199,'imagens/geladeira.jpg',4,0),(4,'004','TV 42\" LCD Scarlet Full HD c/ 3 HDMI Entrada PC USB - PIP - 42LG60 LG',4499,'imagens/tv.jpg',7,0),(5,'005','Aparelho de Ginástica Free Training Kenkorp',399,'imagens/aparelho.jpg',7,0),(6,'006','Câmera Digital 8.2MP Easy Share C813 + 2 Cartões 1GB +Carregador+Bolsa',599,'imagens/camera.jpg',2,0),(7,'007','Sony Ericsson W380 Purple c/ Câmera de 1.3 Mpx, Mp3, 512Mb e Fone',549,'imagens/camera2.jpg',11,0),(8,'008','Kung Fu Panda : o Livro do Filme - DREAMWORKS',19.9,'imagens/livro.jpg',3,0),(9,'009','Caixa Friends 10 Anos - 40 DVDs + Camiseta Grátis',489.5,'imagens/camisa.jpg',9,0),(10,'010','Centrífuga Turbo Juicer Prime - Britânia',299,'imagens/centrifuga.jpg',2,0),(11,'011','Console PS3 com HD 40GB',1499,'imagens/ps3.jpg',23,0),(12,'012','Guitarra California Stratocaster MR - Squier by Fender + Amplificador',799.9,'imagens/guitarra.jpg',9,0),(13,'013','Jamie em Casa - JAMIE OLIVER',63.2,'imagens/livro3.jpg',30,0),(14,'014','Medidor de Pressão Pulso Automático RW350 - G-Tech',99.9,'imagens/pressao.jpg',9,0),(15,'015','Claudia Leitte: ao Vivo em Copacabana',39.9,'imagens/dvd.jpg',2,0),(16,'016','Monitor Cardíaco Masculino TI5G971 Timex',129,'imagens/relogio.jpg',25,0);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-15 12:15:46
