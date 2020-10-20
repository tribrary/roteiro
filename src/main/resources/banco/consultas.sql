-- CONSULTA RETORNE OS ROTEIROS
SELECT * FROM banco_roteiro.roteiros;

-- CONSULTA DE PONTOS
SELECT * FROM banco_roteiro.pontos;

-- CONSULTAR PROGRAMACAO
SELECT programacao.id, programacao.dia, programacao.hora_ida, programacao.hora_volta, motoristas.nome, onibus.placa, roteiros.codigo
FROM programacao inner join motoristas inner join onibus inner join roteiros
on programacao.id_motorista=motoristas.id and programacao.id_onibus=onibus.id and programacao.id_roteiro=roteiros.id;

-- CONSULTAR PROGRAMACAO DE UM DETERMINADO ROTEIRO
SELECT programacao.id, programacao.dia, programacao.hora_ida, programacao.hora_volta, motoristas.nome, onibus.placa, roteiros.codigo
FROM programacao inner join motoristas inner join onibus inner join roteiros
on programacao.id_motorista=motoristas.id and programacao.id_onibus=onibus.id and programacao.id_roteiro=roteiros.id where id_roteiro=1;

-- CONSULTAR CADA PONTO Q CADA ROTEIRO PASSA
SELECT roteiros.codigo, pontos.descricao FROM pontos inner join roteiros inner join roteiro_ponto as rp
on pontos.id=  rp.id_ponto and roteiros.id = rp.id_roteiro;

-- CONSULTAR PONTOS DE UM DETERMINADO ROTEIRO 
SELECT roteiros.codigo, pontos.descricao FROM pontos inner join roteiros inner join roteiro_ponto as rp
on pontos.id=  rp.id_ponto and roteiros.id = rp.id_roteiro
where roteiros.id=1;

-- AGREGAÇÃO 
	-- MAX
	select max(nome) from usuarios;
    
    -- MIN
    select min(nome) from motoristas;
    
    -- SUM
     select sum(duracao) from cursos;
    
    -- COUNT 
    select count(*) from cursos where id_instituicao=2;
    
    -- AVG
	select avg(duracao) from cursos;
    
-- AGRUPAMENTO
	-- GROUP BY
    select cursos.nome, count(*) from cursos 
    group by cursos.nome WITH ROLLUP ;
    
-- DATA
	select * from programacao where dia='2019-12-02';

	select * from programacao where dia between '2019-11-01' and '2019-11-30';
    
-- AGRUPAMENTO E FILTRO POR GRUPO

	select cursos.duracao, count(*) from cursos 
    group by cursos.duracao having max(duracao) > 3;
