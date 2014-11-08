--<ScriptOptions statementTerminator=";"/>

CREATE TABLE Servico (
	idServico INT NOT NULL,
	codigo VARCHAR(45) NOT NULL,
	nome VARCHAR(145) NOT NULL,
	PRIMARY KEY (idServico)
) ENGINE=InnoDB;
