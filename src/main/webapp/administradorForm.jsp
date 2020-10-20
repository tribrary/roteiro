<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body class="body2">
	
	<div class="container body-content ">
		<div class="row">
			<div class="col-lg-1"></div>
			
			<div class="col-lg-10">
				<div class="container centered" id="conteudo">
	<form method="post" action="AdministradorSalvar">
	
	<input type="hidden" name="id" value="${adm.id}">
	<h1 class="tituloForm">Cadastrar Estudante</h1>
		<hr>
	<div class="row">
		<div class="form-group col-lg-6"> 
		<label for="nome">Nome</label> 
			<input class="form-control"  type="text" name="nome"  id="nome" value="${adm.nome}">
		</div>
		<div class="form-group col-lg-6"> 
		<label for="nomeSocial">Nome Social</label> 
			<input class="form-control"  type="text" name="nomeSocial" id="nomeSocial" value="${adm.nomeSocial}">
		</div>
	</div>
	
	<div class="row">
		<div class="form-group col-lg-12"> 
		<label for="email">Email</label> 
			<input class="form-control"  type="email" name="email" id="email" value="${adm.email}">
		</div>
	</div>
	
	<div class="row">
		<div class="form-group col-lg-12">
			<label for="cpf">CPF</label> 
			<input class="form-control"  type="text" name="cpf" id=cpf value="${adm.cpf}">
		</div>
		<div class="form-group col-lg-12">
			<label for="senha">Senha</label> 
			<input class="form-control"  type="password" name="senha" id="senha" value="${adm.senha}">
		</div>
	</div>
	
	<hr>
	
	<label>Endereço</label><br>
	<div class="row">
		<div class="form-group col-lg-6">
		<label for="cep">CEP</label> 
			<input class="form-control" type="text" name="cep" id="Cep" value="${adm.endereco.cep}">
		</div>
		<div class="form-group col-lg-6">
		<label for="cidade">Cidade</label> 
			<input class="form-control" type="text" name="cidade" id="cidade" value="${adm.endereco.cidade}">
		</div>
	</div>
	
	<div class="row">
		<div class="form-group col-lg-4">
		<label for="bairro">Bairro</label> 
			<input class="form-control" type="text" name="bairro" id="bairro" value="${adm.endereco.bairro}">
		</div>
		<div class="form-group col-lg-4">
			<label for="rua">rua</label> 
			<input class="form-control" type="text" name="rua" id="rua" value="${adm.endereco.rua}">
		</div>
		<div class="form-group col-lg-4">
			<label for="numero">numero</label> 
			<input class="form-control" type="text" name="numero" id="numero" value="${adm.endereco.numero}">
		</div>
	</div>
	<button class="btn" type="submit">Enviar</button>
	</form>
	</div>
	</div>
	</div>
	</div>
</body>
</html>