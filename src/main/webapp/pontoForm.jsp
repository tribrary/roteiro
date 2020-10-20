<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet" />
<title>Cadastrar Motorista</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body class="body2">

	<%@include file="./includes/header.jsp"%>
	<div class="container body-content ">
		<div class="row">
			<div class="col-lg-1"></div>

			<div class="col-lg-10">
				<div class="container centered" id="conteudo">

					<form action="./PontoSalvar" method="post">
						<input name="id" type="hidden" value="${ponto.id}">

						<div class="row">
							<div class="form-group col-lg-12">
								<label for="descricao">Descrição</label> <input
									class="form-control" type="text" id="descricao"
									name="descricao" value="${ponto.descricao}">
							</div>
						</div>

						<div class="row">
							<div class="form-group col-lg-6">
								<label for="x">Coordenada X</label> <input class="form-control"
									type="text" id="x" name="x" value="${ponto.x}">
							</div>
							<div class="form-group col-lg-6">
								<label for="y">Coordenada Y</label> <input class="form-control"
									type="text" id="y" name="y" value="${ponto.y}">
							</div>
						</div>


						<button class="btn btnPadrao" type="submit">Salvar</button>
					</form>

				</div>
			</div>
		</div>
	</div>

	<%@include file="./includes/footer.jsp"%>
</body>
</html>