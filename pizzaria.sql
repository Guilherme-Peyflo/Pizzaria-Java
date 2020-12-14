drop database pizzaria;
create database pizzaria;

use pizzaria;

create table tbl_endereco(
		idEndereco int primary key auto_increment,
        logradouro varchar(45) not null,
        endereco varchar(45) not null,
        bairro varchar(45) not null,
        municipio varchar(45) not null,
        estado varchar(45) not null,
        numero int not null
);
insert into tbl_endereco (logradouro,endereco,bairro,municipio,estado,numero) values ('parque','Rua Teixeira','Bogota','Embu','SP',254);
select * from tbl_endereco;

create table tbl_usuario(
		idUsuario int primary key auto_increment,
        nome varchar(45) not null,
        senha varchar(45) not null,
        cpf varchar(11) not null,
        email varchar(45) not null,
        telefone varchar(9) not null,
        isFunc int not null default true,
        fk_Endereco int not null,
		constraint fk_idEndereco foreign key(fk_Endereco) references tbl_endereco(idEndereco)
);
select * from tbl_usuario;

create table tbl_admin(
idAdmin int primary key auto_increment,
nome varchar(45) not null,
senha varchar(45) not null
);

insert into tbl_admin (nome,senha) values("admin","admin");


insert into tbl_usuario (nome,senha,cpf,email,telefone,fk_endereco) values ('Pedro','123456','12541785236','pedrinho1@gmail.com','256345879',1);
create table tbl_pedido(
		idPedido int primary key auto_increment,
        statu varchar(1),
        datas varchar(50) not null,
        hora varchar(50) not null,
        total_pedido varchar(45),
        Usuario_idUsuario int not null,
        constraint Usuario_idUsuario foreign key(Usuario_idUsuario) references tbl_usuario(idUsuario)
);

create table tbl_bordas(
		idBorda int primary key auto_increment,
        tipo_borda varchar(45) not null,
        preco DECIMAL not null
);

create table tbl_pizza(
		idPizza int primary key auto_increment,
		recheio_pizza varchar(45) not null,
        preco DECIMAL not null,
        tamanho char,
        descricao_pizza varchar(45) not null,
        Borda_idBorda int,
        constraint Borda_idBorda foreign key(Borda_idBorda) references tbl_bordas(idBorda)

);

create table tbl_bebida(
		idBebidas int primary key auto_increment,
        nome varchar(45) not null,
        preco decimal not null
);

create table tbl_produtosPedidos(
		 id_pedidoProduto int primary key auto_increment,
         pizza varchar(50) not null,
         borda varchar(50) not null,
		 bebida varchar(50) not null,
		 npiz int not null,
		 nbebi int not null,
         hora timestamp not null default CURRENT_TIMESTAMP,
		 preco decimal not null,   
		 fk_usuario int,
		 constraint fk_usuario foreign key(fk_usuario) references tbl_usuario(idUsuario)
);
		
        
		select * from tbl_produtosPedidos;
        delete from tbl_produtosPedidos where id_pedidoProduto = 4;

insert into tbl_bordas(tipo_borda, preco) values
	('Sem recheio', 0.00),
	('Chocolate', 10.00),
    ('Catupiry', 10.00),
    ('Cheddar', 10.00),
    ('Queijo', 10.00);
    

insert into tbl_bebida(nome, preco) values
		('Sem Bebida', 0.00),
		('Coca-Cola', 8.00),
        ('Pepsi', 8.00),
        ('Guaraná Antarctica', 8.00),
        ('Fanta Laranja', 8.00);
        

insert into tbl_pizza(recheio_pizza, preco, tamanho, descricao_pizza, Borda_idBorda) values
		('Alho e Oleo', 20.00, 'G', 'Uma deliciosa combinação', null),
        ('Calabresa', 20.00, 'G', 'A deliciosa e tradicional', null),
        ('Bacon',20.00, 'G', 'Uma saborosa pizza de bacon', null),
        ('Quatro Queijos', 20.00, 'G', 'A famosa e deliciosa pizza', null),
        ('Camarão com Quejo', 20.00, 'G', 'ótima pizza com uma combinação curiosa', null),
        ('Mussarela', 20.00, 'G', 'Famosa e tradicional', null),
        ('Franco com catupiry', 20.00, 'G', 'Uma saborosa combinação', null),
        ('Marguerita', 20.00, 'G', 'A pizza com as cores da Italia', null),
        ('Portuguesa',20.00, 'G', 'Uma deliciosa combinação de sabores', null),
        ('Pepperoni', 20.00, 'G', 'Recheada especialmente com salame', null),
        ('Chocolate', 20.00, 'G', 'A famosa pizza doce de chocolate', null),
        ('Chocolate com M&Ms', 20.00, 'G', 'A combinação perfeita', null),
        ('Vegetariana',20.00, 'G', 'Especialmente vegetariana', null),
        ('Chocolate Branco', 20.00, 'G', 'Recheada com o delicio chocolate branco', null),
        ('Chocolate Branco com M&Ms', 20.00, 'G', 'A combinação perfeita', null);
select * from tbl_bordas;
select * from tbl_pizza;








