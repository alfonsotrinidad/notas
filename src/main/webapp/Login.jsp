
<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/bootstrapValidator.css">
<link rel="stylesheet" href="css/estilo2.css">

<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.6.4.min.js"></script>
<script src="js/bootstrapValidator.js"></script>
<title>Login</title>
</head>
<body style="display: flex">

<form class="login-form" action="Login" method="post" >
  <p class="login-text">
    <span class="fa-stack fa-lg">
      <i class="fa fa-circle fa-stack-2x"></i>
      <i class="fa fa-lock fa-stack-1x"></i>
    </span>
  </p>
  <input type="text" class="login-username" autofocus="true" name="usuario" required="true" placeholder="Usuario" />
  <input type="password" class="login-password" required="true" name="password" placeholder="Contraseña" />
  <input type="hidden" name="operacion" id="operacion" value="inicio">
  <a href="registro.jsp" class="login-forgot-pass">Registrarse</a>
  <div class="boton">
 	<center> <input type="submit" value="Iniciar Sesión" class="login-submit" /></center>
  </div>
</form>

<div class="underlay-photo"></div>
<div class="underlay-black"></div> 


</body>
</html>




