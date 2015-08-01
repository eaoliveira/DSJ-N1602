CREATE TABLE `CursoJavaDes`.`Produto` (
  `idProduto` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NOT NULL,
  `desc` VARCHAR(450) NOT NULL,
  `validade` DATETIME NOT NULL,
  `preco` DOUBLE NOT NULL,
  PRIMARY KEY (`idProduto`));
 
