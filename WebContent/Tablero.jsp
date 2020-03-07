<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>

<%@ page import="modelo.Moneda"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="theme.css">
<meta charset="ISO-8859-1">
<title>Lanzar la moneda</title>
</head>

<body>
	<form action="SolucionPartidaServlet" method="POST">
		<table class="greenTable">
			<thead>
				<tr>
					<th colspan="2">Estas jugando a lanzar la moneda</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td colspan="5">
						<div class="links">
							<a href="SalirPartidaServlet" class="links">Salir</a>
						</div>
					</td>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td colspan="2">
						<h3>Haz tu apuesta y escoge cara o cruz y tira la moneda</h3>
					</td>
				</tr>
				<tr>
					<td>
						<label for="cara">Cara</label>
						<br> 
						<input type="radio" id="cara" name="Seleccion" value="cara" required  style="width:30px; height:30px;">
					</td>
					<td>
						<label for="cruz">Cruz</label>
						<br> 
						<input type="radio" id="cruz" name="Seleccion" value="cruz" required style="width:30px; height:30px;">					
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Tirar la moneda" class="myButton">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<br>


</body>
</html>

