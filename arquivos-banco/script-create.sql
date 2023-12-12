-- drop database desafioJava;
CREATE database if not exists `desafioJava`;
use desafioJava;

create table if not exists `Cliente`(
idCliente int primary key auto_increment,
email varchar(45),
senha varchar(45)
) auto_increment = 100;

create table if not exists `Componente` (
idComponente int primary key auto_increment,
nomeComponente varchar(45),
unidadeMedida varchar(45),
fkCliente int,
foreign key(fkCliente) references Cliente(idCliente)
) auto_increment = 10;

create table if not exists `Registro`(
idRegistro int primary key auto_increment,
valorRegistro varchar(45),
dtHoraRegistro varchar(45),
fkComponente int,
foreign key(fkComponente) references Componente(idComponente)
) auto_increment = 1;