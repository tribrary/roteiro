<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="atv.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<meta charset="UTF-8">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet" />
<title>Lista de Cursos</title>
<!-- jQuery library -->
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
	<br />

	<br />

	<div class="container body-content ">
		<div class="row">
			<div class="col-lg-1"></div>

			<div class="col-lg-10">
				<div class="container centered" id="conteudo">
					<c:if test="${usuario.papel.id == 1}">
						<a class="btn btnPadra" href="./CursoForm">Novo Curso</a>
					</c:if>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Nome</th>
								<th scope="col">Instituicao</th>
								<th scope="col">Duracao</th>


								<th scope="col"></th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${cursos}">
								<tr>
									<td scope="row">${c.id}</td>
									<td>${c.nome}</td>
									<td>${c.instituicao.nome}</td>
									<td>${c.duracao}</td>

									<td><c:if test="${usuario.papel.id == 1}">
											<c:if test="${c.estudantes.size()>0}">
												<a href='./CursoForm?id=${c.id}'><i
													class="material-icons">edit</i></a>
												<a href='./CursoExcluir?id=${c.id}'><i
													class="material-icons">delete</i></a>
											</c:if>
										</c:if></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<a href="./Painel">Painel</a>

	<%@include file="./includes/footer.jsp"%>
</body>
</html>