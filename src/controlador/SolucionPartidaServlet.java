package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.HashGenerator;
import modelo.Moneda;

/**
 * Servlet implementation class HundirFlotaServlet,
 */
@WebServlet("/SolucionPartidaServlet")
public class SolucionPartidaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SolucionPartidaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int lanzamiento;
		String estadoPartida;
		Moneda moneda = new Moneda();
		String resultado;
		String hash;
		String seleccion;

		try {
			HttpSession sesion = request.getSession(true); // Coger la sesion, si no existe la crea y devuelve

			// Coger la seleccion del jugador (cara / cruz)
			seleccion = request.getParameter("Seleccion");

			if (seleccion != null) {

				lanzamiento = moneda.lanzar();
				resultado = moneda.extraerResultado(lanzamiento);
				hash = HashGenerator.generarHash(lanzamiento + "");
				sesion.setAttribute("seleccion", seleccion);

				if (resultado.equals(seleccion)) {
					estadoPartida = "¡Enhorabuena has ganado!";
				} else {
					estadoPartida = "Mala suerte...";
				}

				// Guardar los objetos en la sesion
				sesion.setAttribute("estadoPartida", estadoPartida);
				sesion.setAttribute("lanzamiento", lanzamiento);
				sesion.setAttribute("resultado", resultado);
				sesion.setAttribute("hash_servidor", hash);
				
			} else {
				estadoPartida = "Ha ocurrida un error al lanzar la moneda";
			}

			// Redirigir la ejecucion al fichero JSP que construira la Vista a mostrar
			// al usuario
			RequestDispatcher vista = request.getRequestDispatcher("TableroSolucion.jsp");
			vista.forward(request, response);

		} catch (

		Exception e) {
			e.printStackTrace();
		}

	}

}
