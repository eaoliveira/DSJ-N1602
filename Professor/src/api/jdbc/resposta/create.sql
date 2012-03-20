drop database contratos;
create database contratos;

CREATE TABLE contratos.contrato (
	idContrato INT NOT NULL AUTO_INCREMENT,
	numero VARCHAR(8) NOT NULL,
	descricao VARCHAR(45) NOT NULL,
	PRIMARY KEY (idContrato)
) ENGINE=InnoDB;