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
<title>Lista de roteiros</title>
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
					<a href="./RoteiroForm">Novo Roteiro</a>
				</c:if>
					<table class="table">
						<tr>
							<th>Id</th>
							<th>Codigo</th>
							<th>Descrição</th>
							<th>Tipo</th>
							<!-- <th><a href="./RoteiroForm">Novo Roteiro</a></th>  -->
						</tr>

						<c:forEach var="r" items="${roteiros}">
							<tr>
								<th>${r.id}</th>
								<th><a href='./PontoListar?idRoteiro=${r.id}'>
										${r.codigo}</a></th>
								<th>${r.descricao}</th>
								<th>${r.tipo}</th>
								<c:if test="${usuario.papel.id == 1}">
								<c:if test="${r.pontos.size() > 0}">
								<th><a href='./RoteiroForm?id=${r.id}'><i
												class="material-icons">edit</i></a> 
								</th>
								</c:if>
								</c:if>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>


	<a href="./Painel">Painel</a>
	<%@include file="./includes/footer.jsp"%>
</body>
</html>