create table enderecos(
id serial primary key,
cep varchar(9) not null, -- ex: 43700-000
cidade varchar(45) not null,
bairro varchar(45) not null,
rua varchar (45) not null,
numero varchar(4)
);

create table instituicoes(
id serial primary key,
nome varchar(45) not null,
id_endereco integer,
foreign key(id_endereco) references enderecos(id)
);

create table cursos (
id serial primary key,
nome varchar(45) not null,
duracao integer not null,
id_instituicao integer,
foreign key (id_instituicao) references instituicoes(id)
);

create table papeis(
id serial primary key,
codigo varchar(45) not null,
descricao varchar(45) not null
);

create table usuarios(
id serial primary key,
nome varchar(45) not null,
nome_social varchar(45),
email varchar(45) not null,
cpf varchar(14) not null, -- 111.222.333-00
senha varchar(45) not null,
id_endereco integer,
id_papel integer,
foreign key (id_endereco) references enderecos(id),
foreign key (id_papel) references papeis(id)
);

create table estudantes(
id serial primary key,
id_curso integer,
id_usuario integer,
foreign key (id_curso) references cursos(id),
foreign key (id_usuario) references usuarios(id)
);

create table onibus(
id serial primary key,
detalhes varchar(45) not null,
situacao varchar(45) not null,
placa varchar(10) not null
);

create table motoristas(
id serial primary key,
nome varchar(45) not null,
descricao varchar(45) not null,
situacao varchar(45) not null
);

create table pontos(
id serial primary key,
descricao varchar(45) not null,
x long,
y long
);

create table roteiros(
id serial primary key,
codigo varchar(10) not null,
descricao varchar(45) not null,
tipo varchar(10) not null
);

create table roteiro_ponto(
id serial primary key,
id_roteiro integer,
id_ponto integer,
foreign key (id_roteiro) references roteiros(id),
foreign key (id_ponto) references pontos(id)
);

create table roteiro_estudante(
id serial primary key,
id_roteiro integer,
id_estudante integer,
foreign key (id_roteiro) references roteiros(id),
foreign key (id_estudante) references estudantes(id)
);

create table programacao(
id serial primary key,
dia date,
hora_ida time,
hora_volta time,
id_onibus integer,
id_motorista integer,
id_roteiro integer,
foreign key (id_onibus) references onibus(id),
foreign key (id_motorista) references motoristas(id),
foreign key (id_roteiro) references roteiros(id)
);