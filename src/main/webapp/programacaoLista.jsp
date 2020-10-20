<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="atv.css">
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet" />
<title>Lista de Pontos</title>
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
						<th><a href="./ProgramacaoForm">Nova Programação</a></th>
					</c:if>
					<table class="table">
						<thead>
							<tr>
								<th>Id</th>
								<th>Roteiro</th>
								<th>Dia</th>
								<th>Hora Ida</th>
								<th>Hora Volta</th>
								<th>Onibus</th>
								<th>Motorista</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="p" items="${programacoes}">
								<tr>
									<td>${p.id}</td>
									<td>${p.roteiro.codigo}</td>
									<td>${p.dia}</td>
									<td>${p.horaIda}</td>
									<td>${p.horaVolta}</td>
									<td>${p.onibus.placa}</td>
									<td>${p.motorista.nome}</td>
									<td><c:if test="${usuario.papel.id == 1}">
											<a href='./ProgramacaoForm?id=${p.id}'><i
												class="material-icons">edit</i></a>
										</c:if></td>

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

