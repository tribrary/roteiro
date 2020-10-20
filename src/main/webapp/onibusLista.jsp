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
<title>Lista de Ônibus</title>
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
					<a href="./OnibusForm">Novo Onibus</a>
</c:if>
					<table class="table">
						<thead>
							<tr>
								<th>Id</th>
								<th>Placa</th>
								<th>Detalhes</th>
								<th>Situacao</th>
								<!-- <th><a  href="./OnibusForm">Novo Onibus</a></th> -->
							</tr>
						</thead>
						<tbody>
							<c:forEach var="o" items="${onibus}">
								<tr>
									<td>${o.id}</td>
									<td>${o.placa}</td>
									<td>${o.detalhes}</td>
									<td>${o.situacao}</td>
									<td>
									<c:if test="${usuario.papel.id == 1}"> 
									
									<a href='./OnibusForm?id=${o.id}'><i
												class="material-icons">edit</i></a> 
									<c:if test="${o.situacao != 'Desabilitado' }">
									<a href='./OnibusForm?situacao=desabilitado&id=${o.id}'><i
												class="material-icons">delete</i></a>
									</c:if>			
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
	<a href="./Painel">Painel</a>

	<%@include file="./includes/footer.jsp"%>
</body>
</html>