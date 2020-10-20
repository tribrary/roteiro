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
				<a href="./PontoForm">Novo ponto</a>
			</c:if>
					<table class="table">
						<thead>
							<tr>
								<th>Id</th>
								<th>Descricao <c:if test="${p.roteiroPontos.size()==0 }">
										<button type="button" class="btn btn-secondary"
											data-toggle="tooltip" data-placement="top"
											title="Este Ponto não pertence a nenhum roteiro">
											Atenção</button>
									</c:if>
								</th>
								<th>Coordenada X<br>Latitude
								</th>
								<th>Coordenada Y<br>Longitude
								</th>
								<th></th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="p" items="${pontos}">
								<tr>
									<td>${p.id}</td>
									<td>${p.descricao}</td>
									<td>${p.x}</td>
									<td>${p.y}</td>
									<c:if test="${usuario.papel.id == 1}">
									<c:if test="${idRoteiro == null}">
										<td><c:if test="${p.roteiroPontos.size()==0 }">
												<a href='./PontoForm?id=${p.id}'><i
												class="material-icons">edit</i></a>
									 	<a href='./PontoExcluir?id=${p.id}'><i
												class="material-icons">delete</i></a>
											</c:if>
											</c:if>
											</td>
									</c:if>
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