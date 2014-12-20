drop table Aluno;
drop table Turma;

create table CursoJavaDes.Turma (
  idTurma integer not null auto_increment,
  titulo varchar(40) not null,
  descricao varchar(250) not null,
  inicio date not null,
  numHoras integer not null,
  primary key (idTurma)
) engine=InnoDB;

create table CursoJavaDes.Aluno (
  matricula integer not null auto_increment,
  nome varchar(40) not null,
  email varchar(30) not null,
  idTurma integer not null,
  foreign key (idTurma) references Turma(idTurma),
  primary key (matricula)
) engine=InnoDB;