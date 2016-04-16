--<ScriptOptions statementTerminator=";"/>

ALTER TABLE produto DROP PRIMARY KEY;

ALTER TABLE compra DROP PRIMARY KEY;

ALTER TABLE itemdecompra DROP PRIMARY KEY;

ALTER TABLE carrinho DROP PRIMARY KEY;

ALTER TABLE item DROP PRIMARY KEY;

ALTER TABLE item DROP INDEX FkItemDoCarrinho;

DROP TABLE carrinho;

DROP TABLE produto;

DROP TABLE itemdecompra;

DROP TABLE compra;

DROP TABLE item;

CREATE TABLE carrinho (
	idCarrinho INT NOT NULL,
	sessao VARCHAR(256) NOT NULL,
	PRIMARY KEY (idCarrinho)
) ENGINE=InnoDB;

CREATE TABLE produto (
	idProduto INT NOT NULL,
	codigo VARCHAR(3) NOT NULL,
	descricao VARCHAR(80) NOT NULL,
	valor FLOAT NOT NULL,
	imagem VARCHAR(30) NOT NULL,
	quantidade INT NOT NULL,
	reservado INT DEFAULT 0,
	PRIMARY KEY (idProduto)
) ENGINE=InnoDB;

CREATE TABLE itemdecompra (
	iditemDeCompra INT NOT NULL,
	codigo VARCHAR(3) NOT NULL,
	nome VARCHAR(40) NOT NULL,
	descricao VARCHAR(80) NOT NULL,
	valor FLOAT NOT NULL,
	imagem VARCHAR(30) NOT NULL,
	quantidade INT NOT NULL,
	idCompra INT,
	PRIMARY KEY (iditemDeCompra)
) ENGINE=InnoDB;

CREATE TABLE compra (
	idCompra INT NOT NULL,
	nome VARCHAR(40) NOT NULL,
	tipo VARCHAR(1) NOT NULL,
	cartao VARCHAR(15) NOT NULL,
	cod VARCHAR(3) NOT NULL,
	valor DOUBLE NOT NULL,
	PRIMARY KEY (idCompra)
) ENGINE=InnoDB;

CREATE TABLE item (
	idItem INT NOT NULL,
	codigo VARCHAR(3) NOT NULL,
	descricao VARCHAR(80) NOT NULL,
	valor FLOAT NOT NULL,
	imagem VARCHAR(30) NOT NULL,
	quantidade INT NOT NULL,
	idCarrinho INT,
	PRIMARY KEY (idItem)
) ENGINE=InnoDB;

CREATE INDEX FkItemDoCarrinho ON item (idCarrinho ASC);

