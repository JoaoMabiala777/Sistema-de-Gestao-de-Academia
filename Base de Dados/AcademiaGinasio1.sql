create database AcademiaGinasio1;
use AcademiaGinasio1;

create table tbusuario(
id int(15) primary key,
Nome varchar(20),
Senha varchar(20)
);
insert into tbusuario(id, Nome, Senha) values (1,'João Cumbo 666', 'mabiala777');
select* from tbusuario where 1;

describe tbfuncionario;
create table tbfuncionario(
id int(15) primary key not null,
Nome varchar(80),
BI varchar(30),
Dat_Nascimento date,
Idade int(20),
Sexo varchar(20),
Morada varchar(20),
Telefone int(20),
Email varchar(30)
);
describe tbmodalidade;
create table tbmodalidade(
id int(15) primary key,
tipoModalidade varchar(20),
valor decimal(15,2) ,
);

describe tbpagamento;
create table tbpagamento(
id int(15) primary key,
Nome varchar(80),
Mes varchar(20),
Dat_Pagamento timestamp default current_timestamp,
Proxi_pagamento date,
valor decimal(15,2),
Multa decimal(15,2)
Exercicio varchar(20),
constraint id_matricula foreign key(id) references tbmatricula(id)
on delete cascade
on update cascade 
);

describe tbaluno;
create table tbaluno(
id int(15) primary key,
Nome varchar(80),
BI varchar(30),
Dat_Nascimento date,
Idade int(20),
Sexo varchar(20),
Morada varchar(20),
Telefone int(20),
Email varchar(30)  
);
select* from tbaluno where 1;

describe tbmatricula;
create table tbmatricula(
id int(15) primary key,
Nome varchar(80),
valor decimal(15,2),
Dat_Matricula timestamp default current_timestamp
Excercicio varchar(80),
PrecoModalidade decimal(15,2),
PlanoPagamento varchar(80)
constraint id_aluno foreign key(id) references tbaluno(id)
on delete cascade
on update cascade 
);

create table tbavaliacao(
id int(15) primary key,
Peso decimal(15,2),
Altura decimal(15,2),
Idade int(20),
sexo varchar(20),
Nivel_Colesterol decimal(15,2),
Pressao_Arterial decimal(15,2),
);


