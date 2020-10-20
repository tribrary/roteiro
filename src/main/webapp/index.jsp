<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

	 <link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />

	<link rel="stylesheet" type="text/css" href="atv.css">
</head>
<body class="body">

<div class="container">
		<div class="row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6 ColLogin">
				<form method="post" action="./LoginServlet">
				<div class="row centered">
					<div class="col-lg-1"></div>
					<div class="col-lg-10">
						<br>
						<h4 class="titulo">ACESSO RESTRITO</h4>
						<br>

						
							<div class="form-group centered">
								<label for="login">Login</label><br>
								<input type="text" class="form-control" name="login" id="login">
							</div>
							<div class="form-group centered">
								<label for="senha">Senha</label><br>
								<input type="password" class="form-control" name="senha" id="senha">
							</div>
							${erro}

						
					</div>
					<div class="col-lg-1"></div>
				</div>
				<br>
				<div class="row">
					<div class="col-lg-3"></div>
					<div class="col-lg-3">
						<button type="submit" class="btn btnLogin" >Entrar</button>	
					</div>	
					<div class="col-lg-3">
						<input type="button" class="btn btnLogin" name="recuperarSenha" value="Recuperar Senha">
					</div>
					<div class="col-lg-3"></div>
				</div>
				</form>
				<br>
				<hr>
				<br>
				<div class="row centered">
					<div class="col-lg-3"></div>
					<div class="col-lg-6 centered">
						<p class="texto">Transporte Universitário</p>
						<p class="texto">2019 © - Qualquer coisa</p>
					</div>
					<div class="col-lg-3"></div>			
				</div>	
			</div>
			<div class="col-lg-3"></div>
		</div>
		
	</div>
</body>
</html>