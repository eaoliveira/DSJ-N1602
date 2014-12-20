create table associado (
	idAssociado integer not null auto_increment,
	nome varchar(40) not null,
	endereco varchar(50) not null,
	idade integer not null,
	telefone varchar(9) not null,
	email varchar(25) not null,
	primary key (idAssociado)
) Engine InnoDB;

create table atividade (
	idAtividade integer not null auto_increment,
	nome varchar(40) not null,
	valor double not null,
	primary key (idAtividade)
) Engine InnoDB;

create table agenda (
	idAgenda integer not null auto_increment,
	idAssociado integer not null,
	idAtividade integer not null,
	horario varchar(10) not null,
	primary key (idAgenda)
) Engine InnoDB;
