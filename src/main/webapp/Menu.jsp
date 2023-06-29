<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
<link rel="stylesheet" href="css/estilo1.css">
<link rel="stylesheet" href="css/estilo2.css">
<link rel="stylesheet" href="css/menu.css">
<script src="https://kit.fontawesome.com/60e108111f.js"
	crossorigin="anonymous"></script>
<script src="js/javascript1.js"></script>
<title>Insert title here</title>
</head>
<body id="body-pd">
.<%
  String usuario = (String)request.getAttribute("usuario");
  session.setAttribute("usuario",usuario);
  
  
  String docente = (String)request.getAttribute("docente");
  session.setAttribute("docente",docente);
  
  
  
  String prueba = (String)request.getAttribute("pruebas");
  session.setAttribute("pruebas",prueba);
 
  String seccion = (String)request.getAttribute("seccion");
  session.setAttribute("seccion",seccion);
 
  String asignaturas = (String)request.getAttribute("asignaturas");
  session.setAttribute("asignaturas",asignaturas);
 
  String grupos = (String)request.getAttribute("grupos");
  session.setAttribute("grupos",grupos);
  
  String modas = (String)request.getAttribute("modas");
  session.setAttribute("modas",modas);
  
  String secciones = (String)request.getAttribute("secciones");
  session.setAttribute("secciones",secciones);
 
  String notas = (String)request.getAttribute("notas");
  session.setAttribute("notas",notas);
  
  
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
					<a href="#" class="nav_link"> <i class='bx bx-home nav_icon'></i>
						<span class="nav_name">Inicio</span>
					</a> <a href="RegistroNotasProfesor.jsp" class="nav_link active"> <i
						class='bx bx-book-open nav_icon'></i> <span class="nav_name">Ver
							mis notas</span>
					</a> <a href="#" class="nav_link"> <i class='bx bx-user nav_icon'></i>
						<span class="nav_name">Cerrar Sesión</span>
					</a>
				</div>
			</div>
		</nav>
	</div>
	<section class="articles">
		<article>
			<div class="article-wrapper">
				<figure>
					<img class="imgcard"
						src="https://www.cibertec.edu.pe/wp-content/uploads/2019/06/sede-bellavista-card-257x300.jpg"
						alt="" />
				</figure>
				<div class="article-body">
					<h2>Cibertec</h2>
					<p>Cibertec inicia sus actividades en el año 1983 con la
						finalidad de presentar un proyecto alternativo de formación
						superior en el campo de la Computación e Informática. Hoy Cibertec
						es el Primer Centro Autorizado de Enseñanza en el Perú. Tiene
						licencia para funcionar como Centro Autorizado de Exámenes Sylvan
						Prometric desde 1983; por el que puede ofrecer a sus estudiantes
						Exámenes de Certificación con validez internacional.</p>
					<a href="https://www.cibertec.edu.pe/conocenos/somos-cibertec/"
						class="read-more"> Read more <svg
							xmlns="http://www.w3.org/2000/svg" class="icon"
							viewBox="0 0 20 20" fill="currentColor">
            <path fill-rule="evenodd"
								d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z"
								clip-rule="evenodd" />
          </svg>
					</a>
				</div>
			</div>
		</article>
		<article>

			<div class="article-wrapper">
				<figure>
					<img class="imgcard"
						src="https://www.cibertec.edu.pe/wp-content/uploads/2019/07/imageAcordion-1.png"
						alt="" />
				</figure>
				<div class="article-body">
					<h2>Computación e Informatica</h2>
					<p>La Computación es la disciplina que se encarga del estudio
						de las computadoras, abarcando su diseño, desarrollo y
						procesamiento (hardware), mientas que la Informática recoge y
						ordena los datos convirtiéndolos en información sencilla
						(software).</p>
					<a href="#" class="read-more"> </a>
				</div>
			</div>
		</article>
		<article>

			<div class="article-wrapper">
				<figure>
					<img class="imgcard"
						src="https://www.cibertec.edu.pe/wp-content/uploads/2022/04/CARD-INGENIERIA-310X310-n.jpeg"
						alt="" />
				</figure>
				<div class="article-body">
					<h2>Acerca de Nuestro Proyecto</h2>
					<p>Buscamos simular una parte pequeña del sistem Blackboard,
						que vendría a ser el registro de notas a los estudiantes por parte
						del profesor y la visualización de estas por parte del alumno.</p>
					<a href="#" class="read-more"> </a>
				</div>
			</div>
		</article>
	</section>
</body>
</html>