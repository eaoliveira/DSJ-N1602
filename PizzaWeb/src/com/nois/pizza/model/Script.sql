DROP TABLE pizza;

CREATE TABLE pizza (
	id INT NOT NULL primary key auto_increment,
	nome VARCHAR(45) NOT NULL,
	grupo VARCHAR(45) NOT NULL,
	descricao VARCHAR(250) NOT NULL,
	imagemGrande VARCHAR(45) NOT NULL,
	imagemPequena VARCHAR(45) NOT NULL,
	preco DOUBLE NOT NULL
) ENGINE=InnoDB default charset=utf8;

