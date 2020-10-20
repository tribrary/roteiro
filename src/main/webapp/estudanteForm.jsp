<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"
	type="text/javascript"></script>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet" />
<title>Cadastrar estudante</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="roteiro.js"></script>
<link rel="stylesheet" type="text/css" href="atv.css">
</head>
<body class="body2">
	<%@include file="./includes/header.jsp"%>



	<div class="container body-content ">
		<div class="row">
			<div class="col-lg-1"></div>

			<div class="col-lg-10">
				<div class="container centered" id="conteudo">
					<form method="post" action="EstudanteSalvar">

						<input type="hidden" name="id" value="${estudante.usuario.id}">
						<h1 class="tituloForm">Cadastrar Estudante</h1>
						<hr>
						<div class="row">
							<div class="form-group col-lg-6">
								<label for="nome">Nome</label> <input class="form-control"
									type="text" name="nome" id="nome"
									value="${estudante.usuario.nome}">
							</div>
							<div class="form-group col-lg-6">
								<label for="nomeSocial">Nome Social</label> <input
									class="form-control" type="text" name="nomeSocial"
									id="nomeSocial" value="${estudante.usuario.nomeSocial}">
							</div>
						</div>

						<div class="row">
							<div class="form-group col-lg-12">
								<label for="email">Email</label> <input class="form-control"
									type="email" name="email" id="email"
									value="${estudante.usuario.email}">
							</div>
						</div>

						<div class="row">
							<div class="form-group col-lg-6">
								<label for="cpf">CPF</label> <input class="form-control"
									type="text" name="cpf" id=cpf value="${estudante.usuario.cpf}">
							</div>
							<div class="form-group col-lg-6">
								<label for="senha">Senha</label> <input class="form-control"
									type="password" name="senha" id="senha"
									value="${estudante.usuario.senha}">
							</div>
						</div>

						<hr>
						<label>Curso</label>

						<div class="form-group col-lg-12">
							<select class="form-control" name="curso">
								<c:forEach var="c" items="${cursos}">

									<option value="${c.id}"
										${ c.id == estudante.curso.id ? 'selected' : ''}>${c.nome}
									</option>
								</c:forEach>
							</select>
						</div>

						<hr>

						<label>Endereço</label><br>
						<div class="row">
							<div class="form-group col-lg-6">
								<label for="cep">CEP</label> <input class="form-control"
									type="text" name="cep" id="cep"
									value="${estudante.usuario.endereco.cep}">
							</div>
							<div class="form-group col-lg-6">
								<label for="cidade">Cidade</label> <input class="form-control"
									type="text" name="cidade" id="cidade"
									value="${estudante.usuario.endereco.cidade}">
							</div>
						</div>

						<div class="row">
							<div class="form-group col-lg-4">
								<label for="bairro">Bairro</label> <input class="form-control"
									type="text" name="bairro" id="bairro"
									value="${estudante.usuario.endereco.bairro}">
							</div>
							<div class="form-group col-lg-4">
								<label for="rua">rua</label> <input class="form-control"
									type="text" name="rua" id="rua"
									value="${estudante.usuario.endereco.rua}">
							</div>
							<div class="form-group col-lg-4">
								<label for="numero">numero</label> <input class="form-control"
									type="text" name="numero" id="numero"
									value="${estudante.usuario.endereco.numero}">
							</div>
						</div>




						<div class="row">
							<div class="col-lg-6 col-sm-12">
								<label>Roteiros cadastrados</label>
								<div class="form-group">
									<div class=" ms-lista">
										<ul class="list-group list-group-flush" id="cadastradas">
											<c:forEach var="r" items="${roteiros}">
												<li class="list-group-item" value="${r.id}">${r.codigo}</li>
											</c:forEach>

										</ul>
									</div>
								</div>
							</div>
							<div class="col-lg-6 col-sm-12">
								<label>Roteiros do Estudante</label>
								<div class="ms-lista">
									<ul id="salvar" class="list-group list-group-flush">
										<c:forEach var="rc" items="${roteirosCadastrados}">
											<li class="list-group-item" value="${rc.id}">
												${rc.codigo} <input type='checkbox' name='salvar'
												id='salvar' class='chkTags' checked='checked'
												value="${rc.id}">
											</li>
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
						
						<button class="btn btnPadrao" type="submit">Enviar</button>

					</form>
				</div>
			</div>
		</div>
	</div>
	<br />

	<%@include file="./includes/footer.jsp"%>
</body>
</body>
</html>
