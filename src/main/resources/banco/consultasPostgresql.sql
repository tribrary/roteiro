-- CONSULTAR PROGRAMACAO
SELECT programacao.id, programacao.dia, programacao.hora_ida, programacao.hora_volta, motoristas.nome, onibus.placa, roteiros.codigo
FROM programacao inner join motoristas on (programacao.id_motorista=motoristas.id) inner join onibus on (programacao.id_onibus=onibus.id)
inner join roteiros on (programacao.id_roteiro=roteiros.id);

-- CONSULTAR PROGRAMACAO DE UM DETERMINADO ROTEIRO
SELECT programacao.id, programacao.dia, programacao.hora_ida, programacao.hora_volta, motoristas.nome, onibus.placa, roteiros.codigo
FROM programacao inner join motoristas on (programacao.id_motorista=motoristas.id) inner join onibus on (programacao.id_onibus=onibus.id)
inner join roteiros on (programacao.id_roteiro=roteiros.id) where id_roteiro=1;

-- CONSULTAR CADA PONTO Q CADA ROTEIRO PASSA
SELECT roteiros.codigo, pontos.descricao FROM pontos 
inner join roteiro_ponto rp on (pontos.id=  rp.id_ponto)
inner join roteiros on (roteiros.id = rp.id_roteiro) ;

-- CONSULTAR PONTOS QUE UM ROTEIRO PASSA
SELECT  pontos.descricao FROM pontos 
inner join roteiro_ponto rp on (pontos.id=  rp.id_ponto)
inner join roteiros on (roteiros.id = rp.id_roteiro) where id_roteiro=1;

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
    group by cursos.nome;
    
-- DATA
	select * from programacao where dia='2019-12-02';

	select * from programacao where dia between '2019-11-01' and '2019-11-30';
    
-- AGRUPAMENTO E FILTRO POR GRUPO quantidade de cursos que tem mais de 3 anos de duração
	select cursos.duracao, count(*) from cursos 
    group by cursos.duracao having max(duracao) > 3;