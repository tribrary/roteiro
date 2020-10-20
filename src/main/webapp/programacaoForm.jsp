<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet" />
<title>Gerenciar Programação</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="atv.css">
</head>
<body class="body2">

	<%@include file="./includes/header.jsp"%>
	<div class="container body-content ">
		<div class="row">
			<div class="col-lg-1"></div>

			<div class="col-lg-10">
				<div class="container centered" id="conteudo">
					<form action="./ProgramacaoSalvar" method="post">

						<input name="id" type="hidden" value="${programacao.id}">
						<h1 class="tituloForm">Editar Programação</h1>
						<hr>
						<div class="row">
						<div class="form-group col-lg-4">
								<label for="dia">Data</label> <input class="form-control"
									type="date" id="dia" name="dia"
									value="${programacao.dia}">
						</div>
						<div class="form-group col-lg-4">
								<label for="horaIda">Hora de saída</label> <input class="form-control"
									type="time" id="horaIda" name="horaIda"
									value="${programacao.horaIda}">
						</div>
						<div class="form-group col-lg-4">
								<label for="horaVolta">Hora de saída</label> <input class="form-control"
									type="time" id="horaVolta" name="horaVolta"
									value="${programacao.horaVolta}">
						</div>
						</div>
						<div class="row">
						<div class="form-group col-lg-4">
							<label for="roteiro">Roteiro</label> <select
								class="form-control" name="roteiro" id="roteiro">
								<option value="">Selecione</option>
								<c:forEach var="roteiro" items="${roteiros}">
									<option value="${roteiro.id}"
										${ roteiro.id == programacao.roteiro.id ? 'selected' : ''}>${roteiro.codigo}
									</option>
								</c:forEach>
							</select>
						</div>
						
						<div class="form-group col-lg-4">
							<label for="motorista">Motorista</label> <select
								class="form-control" name="motorista" id="motorista">
								<option value="">Selecione</option>
								<c:forEach var="motorista" items="${motoristas}">
									<option value="${motorista.id}"
										${ motorista.id == programacao.motorista.id ? 'selected' : ''}>${motorista.nome}
									</option>
								</c:forEach>
							</select>
						</div>
						
						<div class="form-group col-lg-4">
							<label for="onibus">Ônibus</label> <select
								class="form-control" name="onibus" id="onibus">
								<option value="">Selecione</option>
								<c:forEach var="onibus" items="${onibus}">
									<option value="${onibus.id}"
										${ onibus.id == programacao.onibus.id ? 'selected' : ''}>${onibus.placa}
									</option>
								</c:forEach>
							</select>
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