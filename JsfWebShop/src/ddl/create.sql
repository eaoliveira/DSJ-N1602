drop table produto;
drop table compra;
CREATE TABLE `produto` (
  `idProduto` INTEGER  NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(3)  NOT NULL,
  `descricao` VARCHAR(80)  NOT NULL,
  `valor` FLOAT  NOT NULL,
  `imagem` VARCHAR(30) NOT NULL,
  `quantidade` INTEGER NOT NULL,
  `reservado` INTEGER DEFAULT 0,
  PRIMARY KEY (`idProduto`)
)
ENGINE = InnoDB;

CREATE TABLE `compra` (
  `idCompra` INTEGER  NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(40)  NOT NULL,
  `tipo` VARCHAR(1)  NOT NULL,
  `cartao` VARCHAR(15)  NOT NULL,
  `cod` VARCHAR(3)  NOT NULL,
  `valor` DOUBLE  NOT NULL,
  PRIMARY KEY (`idCompra`)
)
ENGINE = InnoDB;
