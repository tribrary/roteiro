
<nav class="navbar navbar-light barraNavegacao">
</nav>

<nav class="navbar  navbar-expand-lg navbar-light barraNavegacao2">
	<a class="navbar-brand" href="#">LOGO</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav">
			<li class="nav-item active itensNavbar"><a class="nav-link "
				href="dashboardAdmin.jsp">IN�CIO<span class="sr-only">(current)</span></a></li>

			<li class="nav-item dropdown itensNavbar"><a
				class="nav-link dropdown-toggle" href="#"
				id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> SERVI�OS </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="./EstudanteListar">ESTUDANTES</a> <a
						class="dropdown-item" href="./InstituicaoListar">INSTITUI��ES</a>
					<a class="dropdown-item" href="./RoteiroListar">ROTEIROS</a> <a
						class="dropdown-item" href="./PontoListar">PONTOS</a> <a
						class="dropdown-item" href="./CursoListar">CURSOS</a> <a
						class="dropdown-item" href="./OnibusListar">VE�CULOS</a>
					<a	class="dropdown-item" href="./ProgramacaoListar">PROGRAMA��O</a>
				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#"
				id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> FUNCIONARIOS </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="./MotoristaListar">MOTORISTAS</a> <a
						class="dropdown-item" href="./AdministradorListar">ADMINISTRADORES</a>
				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#"
				id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> NOTIFICA��ES </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="#">OP��O 1</a> <a
						class="dropdown-item" href="#">OP��O 2</a>
				</div></li>

				


		</ul>
	</div>
</nav>
<div class="logout">
	<div class="cor">
	<a href="./LogoutServlet">Logout</a>
	</div>
</div>