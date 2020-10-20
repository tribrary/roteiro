<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="atv.css">
<title>Bem vindo!</title>
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
	
	<div class="container body-content ">
		<div class="row">
			<div class="col-lg-1"></div>
			
			<div class="col-lg-10">
				<div class="container centered" id="conteudo">
					<div class="row centered">
						<h4 class="titulo">Olá, ${usuario.nome}</h4>
					</div>
					<hr>
					<div class="row">
						<div class="col-lg-4">
							
						</div>
						<div class="col-lg-8">
							
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="col-lg-1"></div>
		</div>
	</div>
            
	<%@include file="./includes/footer.jsp"%>

   


</body>
</html>