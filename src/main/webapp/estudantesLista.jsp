<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="atv.css">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet" />
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<title>Estudantes</title>
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
					<c:if test="${usuario.papel.id == 1}">
						<a class="btn btn-default" href="./EstudanteForm">Cadastrar
							Estudante</a>
					</c:if>
					<table class="table">
						<thead>
							<tr>
								<th>Nome</th>
								<th>CPF</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="e" items="${estudantes}">
								<tr>
									<td>${ e.nome}</td>
									<td>${e.cpf}</td>
									<td>
									<c:if test="${usuario.papel.id == 1}">
									<a href="./EstudanteForm?id=${e.id}"><i
												class="material-icons">edit</i></a>
									<a href="./EstudanteExcluir?id=${e.id}"><i
												class="material-icons">delete</i></a>
												</c:if>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<%@include file="./includes/footer.jsp"%>
</body>
</html>