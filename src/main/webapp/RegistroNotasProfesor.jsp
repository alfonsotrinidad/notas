
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); // 
    
    
%>

<%-- <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> --%>
	<%@page import="java.util.List" %>
	<%@page import="controlador.Login" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href='https://fonts.googleapis.com/css?family=Poppins' rel='stylesheet'>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/css/bootstrap-select.min.css">
<link rel="stylesheet" href="css/notas.css">
<link rel="stylesheet" href="css/estilo1.css">
<link rel="stylesheet" href="css/estilo2.css">
<link rel="stylesheet" href="css/menu.css">
<script src="https://kit.fontawesome.com/60e108111f.js"
	crossorigin="anonymous"></script>
<script src="js/javascript1.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body id="body-pd">
.<%

  String usuario = (String)session.getAttribute("usuario");

  

  String prueba = (String)session.getAttribute("pruebas");
  String seccion = (String)session.getAttribute("secciones");
  String asignaturas = (String)session.getAttribute("asignaturas");
  String grupos = (String)session.getAttribute("grupos");
  String profesores = (String)session.getAttribute("profesores");
  String asign_notas = (String)session.getAttribute("notas");
  String modas = (String)session.getAttribute("modas");
  String notas = (String)session.getAttribute("notas");
  String matriculados = (String)session.getAttribute("matriculados");
  
  
  %>
	<header class="header" id="header">
		<div class="header_toggle">
			<i class='bx bx-menu' id="header-toggle"></i>
		</div>
		<div class="Usuario">
			<h4><%= usuario%></h4>
			
		</div>
	</header>
	<div class="l-navbar" id="nav-bar">
		<nav class="nav">

			<div>
				<a href="#" class="nav_logo"> <i
					class='bx bx-layer nav_logo-icon'></i> <span class="nav_logo-name">CIBERTEC</span>
				</a>
				<div class="nav_list">
					<a href="Menu.jsp" class="nav_link"> <i class='bx bx-home nav_icon'></i>
						<span class="nav_name">Inicio</span>
					</a> <a href="#" class="nav_link active"> <i
						class='bx bx-book-open nav_icon'></i> <span class="nav_name">Ver
							mis notas</span>
					</a> <a href="#" class="nav_link"> <i class='bx bx-user nav_icon'></i>
						<span class="nav_name">Cerrar Sesión</span>
					</a>
				</div>
			</div>
		</nav>
	</div>

	<div class="bloque">
		<div class="filtrotop">
	
			<div class="modalidad">
				<label style="margin-right: 5px">Modalidad de Estudio</label>
				<div class="select-dropdown">
					<select>
						<%= modas%>
					</select>
				</div>
			</div>
			<div class="cicloacademico">
				<label style="margin-right: 5px">Ciclo Academico</label>
				<div class="select-dropdown">
					<select>
				     	<option value="Option 1">202381</option>
						<option value="Option 2">2nd Option</option>
						<option value="Option 3">Option Number 3</option> 
					</select>
				</div>
			</div>
		</div>
		<hr>
		<div>
			<h2 class="titulo">Preingreso de Notas</h2>
			<p>Permite el preingreso de las notas de los alumnos</p>
		</div>
		<hr
			style="width: 700px; margin-left: 28px; border-top: 3px dashed #4723d9">
		<div class="filtros">
			<div class="profesor">
				<label style="margin-right: 67px">Profesor</label>
				<div class="">
				
				<h1><%= usuario%></h1>
					
				</div>
			</div>
			<div class="asignatura">
				<label style="margin-right: 40px">Asignatura</label>
				<div class="select-dropdown">
					<select class="filtrosbot">
						<%= asignaturas%>
					</select>
				</div>
			</div>
			<div class="filtrosg">
			<div class="seccion">
				<label style="margin-right: 68px">Sección</label>
				<div class="select-dropdown">
					<select class="filtrosbot">
						<%= seccion%>
					</select>
				</div>
			</div>
			<div class="seccion">
				<label style="margin-left: 30px;margin-right: 49px">Grupo</label>
				<div class="select-dropdown">
					<select class="filtrosbot">
						<%= grupos%>
					</select>
				</div>
			</div>
			</div>
			
			<div class="filtrosg">
			<div class="seccion">
				<label style="margin-right: 28px">Tipo Prueba</label>
				<div class="select-dropdown">
					<select class="filtrosbot">
						<%= prueba%>
					</select>
				</div>
			</div>
			<div class="seccion">
				<label style="margin-right: 15px;margin-left: 30px">N° Prueba</label>
				<div class="select-dropdown">
					<select class="filtrosbot">
						<%= asign_notas%>
					</select>
				</div>
			</div>
			</div>
		</div>
		<!-- --------- -->
		<div class="tablanotas">
					<div>
					<form action="Login" method="post">
					<input type="hidden" id="operacion" value="filtrar">  
						<div class="col-md-3" style="margin-top: 20px">
							<button type="submit"  class="btn btn-primary" id="validateBtnw1" >FILTRAR</button><br>&nbsp;<br>
						</div>
					</form>
					</div>
					<div class="row" > 
						<div class="col-md-10">
								<div class="content" style="overflow: scroll; height: 300px">
						
									<table id="mitabla" class="table table-striped table-bordered" >
										<thead >
											<tr>
												<th>Id Alumno</th>
												<th>Nombre</th>
												<th>Apellidor</th>
												<th>Nota</th>
											</tr>
										</thead>
										<tbody>
											<%= matriculados%>	     
 										</tbody>
										</table>	
									
								</div>	
						</div>
					</div>
					</div>
		<!-- --------- -->
	</div>


</body>
</html>