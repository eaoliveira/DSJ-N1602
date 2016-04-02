CREATE TABLE funcionario (
	idFuncionario INT NOT NULL auto_increment,
	nome VARCHAR(25) DEFAULT '' NOT NULL,
	matricula VARCHAR(6) DEFAULT '' NOT NULL,
	primary key (idFuncionario)
) Engine=InnoDB;

CREATE TABLE telefone (
	idFone INT NOT NULL auto_increment,
	idFuncionario INT DEFAULT 0 NOT NULL,
	ddd VARCHAR(2) DEFAULT '' NOT NULL,
	numero VARCHAR(9) DEFAULT '' NOT NULL,
	primary key (idFone, idFuncionario)
) Engine=InnoDB;

