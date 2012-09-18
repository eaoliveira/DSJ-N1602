create database escola;

CREATE TABLE escola.aluno (
	idAluno INTEGER NOT NULL auto_increment,
	nome varchar(45) NOT NULL,
	matricula VARCHAR(6) NOT NULL,
	PRIMARY KEY (idAluno)
) ENGINE=InnoDB;
