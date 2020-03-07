<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*" import ="modelo.HashGenerator"%>

<%@ page import="modelo.Moneda"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="theme.css">
<meta charset="ISO-8859-1">
<title>Lanzar la moneda</title>
</head>

<body>

	<%
		//cargar sesion

		try {
			HttpSession sesion = request.getSession();

			String estadoPartida = (String) sesion.getAttribute("estadoPartida");
			int lanzamiento = (int) sesion.getAttribute("lanzamiento");
			String resultado = (String) sesion.getAttribute("resultado");
			String hash_servidor = (String) sesion.getAttribute("hash_servidor");
			String seleccion=(String) sesion.getAttribute("seleccion");
			
			String hash_cliente=HashGenerator.generarHash(lanzamiento+"");
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
						<a class="links" href="LanzarLaMonedaServlet">Volver a jugar</a> 
						<a class="links" href="SalirPartidaServlet">Salir</a>
					</div>
				</td>
			</tr>
		</tfoot>
		<tbody>
			<tr>
				<td>
					<b class="titulo2"><%=estadoPartida%></b> <br>
					Ha salido <%=resultado%> <br>
					Tu elección ha sido <%=seleccion%> <br> <br>
					
					<b> Datos debug: </b> <br>
					Hash servidor: <%=hash_servidor%> <br>
					Hash cliente:  <%=hash_cliente%> <br>
					Valor lanzamiento: <%=lanzamiento%> <br>
					Resultado lanzamiento: <%=resultado%> <br>
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

