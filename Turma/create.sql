create table turma (
       idTurma integer not null auto_increment,
       titulo varchar(40) not null,
       descricao varchar(250) not null,
       inicio date not null,
       numHoras integer not null,
       primary key (idTurma)
     ) engine=InnoDB;
     
     create table aluno (
       matricula integer not null auto_increment,
       nome varchar(40) not null,
       email varchar(30) not null,
       idTurma integer not null,
       foreign key (idTurma) references root.turma(idTurma),
       primary key (matricula)
     ) engine=InnoDB;
