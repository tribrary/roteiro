<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet" />
<title>Insert title here</title>
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

					<form method="post" action="./InstituicaoSalvar">
						<input type="hidden" name="id" value="${instituicao.id}">

						<div class="row">
							<div class="form-group col-lg-12">
								<label for="nomeInstituicao">Nome da Instituição</label> <input
									type="text" name="nome" class="form-control"
									value="${instituicao.nome}">
							</div>
						</div>

						<hr>
						<label>Endereço</label><br>

						<div class="row">
							<div class="form-group col-lg-6">
								<label for="cep">CEP</label> <input type="text" name="cep"
									class="form-control" id="cep"
									value="${instituicao.endereco.cep}">
							</div>
							<div class="form-group col-lg-6">
								<label for="cidade">Cidade</label> <input type="text"
									name="cidade" class="form-control" id="cidade"
									value="${instituicao.endereco.cidade}">
							</div>
						</div>


						<div class="row">
							<div class="form-group col-lg-4">
								<label for="bairro">Bairro</label> <input type="text"
									id="bairro" name="bairro" class="form-control"
									value="${instituicao.endereco.bairro}">
							</div>
							<div class="form-group col-lg-4">
								<label for="rua">Rua</label> <input type="text" id="rua"
									name="rua" class="form-control"
									value="${instituicao.endereco.rua}">
							</div>
							<div class="form-group col-lg-4">
								<label for="numero">Instituição</label> <input type="text"
									id="numero" name="numero" class="form-control"
									value="${instituicao.endereco.numero}">
							</div>
						</div>
						<button class="btn btnPadrao" type="submit">Enviar</button>
					</form>

				</div>
			</div>
		</div>
	</div>

	<%@include file="./includes/footer.jsp"%>
</body>
</html>