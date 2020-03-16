<%@ page language="java" 
contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1" 
import="java.util.*" 
import="modelo.HashGenerator"%>
<%@ page import="modelo.Moneda"%>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="theme.css">
		<meta charset="ISO-8859-1">
		<title>Lanzar la moneda</title>
		<script type="text/javascript" src="core.js"></script>
		<script type="text/javascript" src="md5.js"></script>
	</head>

	<body>

		<%
		//Sacamos todas las variables que hemos metido en el objeto sesion para mostrarlos al cliente
		try {
			HttpSession sesion = request.getSession();

			String estadoPartida = (String) sesion.getAttribute("estadoPartida");
			int lanzamiento = (int) sesion.getAttribute("lanzamiento");
			String resultado = (String) sesion.getAttribute("resultado");
			String hash_servidor = (String) sesion.getAttribute("hash_servidor");
			String seleccion = (String) sesion.getAttribute("seleccion");
		%>

		<table class="greenTable">
			<thead>
				<tr>
					<th>Resultados de lanzar la moneda</th>
				</tr>
			</thead>
			
			<tfoot>
				<tr>
					<td>
						<div class="links">
							<a class="links" href="LanzarLaMonedaServlet">	Volver a jugar	</a>  
							<a class="links" href="SalirPartidaServlet">	Salir			</a>
						</div>
					</td>
				</tr>
			</tfoot>
			
			<tbody>
				<tr>
					<td>
						<b class="titulo2"> <%=estadoPartida%></b> 		<!-- Mensaje que dice "Enhorabuena" o "mala suerte" -->
					
						<br> Ha salido <%=resultado%>  					<!--cara/cruz -->
						<br> Tu elección ha sido <%=seleccion%> 		<!--cara/cruz -->
						
						<br> 
						<br> 
						<b> Datos debug: </b> 
						<br> Hash servidor: <i> <%=hash_servidor%> </i> <!--Calculado por el servidor -->
						<br> Hash cliente: <i id="hashCliente"></i>   	<!--Calculado por el cliente con js -->
							
							<script type="text/javascript">
								var hashC = CryptoJS.MD5("<%=lanzamiento%>"); 
								document.getElementById("hashCliente").innerHTML = hashC;
							</script> 
							
						<br> Valor lanzamiento: <%=lanzamiento%> 		<!--Entero resultado de hacer un random -->
						<br> Resultado lanzamiento: <%=resultado%> 		<!--cara/cruz -->
						<br>
					
					</td>
				</tr>
	
			</tbody>
		</table>
	
	
		<br>
		<br>

	<%
		} catch (Exception e) {
		}
	%>
</body>
</html>

