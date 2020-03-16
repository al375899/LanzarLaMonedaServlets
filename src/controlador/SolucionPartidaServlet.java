package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.HashGenerator;
import modelo.Moneda;

@WebServlet("/SolucionPartidaServlet")
public class SolucionPartidaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SolucionPartidaServlet() {
		super();
	}

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

				lanzamiento = moneda.lanzar(); 						//Se hace un random entre 0 y 100.000
				resultado = moneda.extraerResultado(lanzamiento); 	//Cara o Cruz
				hash = HashGenerator.generarHash(lanzamiento + ""); //El servidor calcula el hash del resultado
				sesion.setAttribute("seleccion", seleccion);		//Guardamos la seleccion del usuario en la sesion

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

			// Redirigir la ejecucion al fichero JSP que construira la Vista a mostrar al usuario
			RequestDispatcher vista = request.getRequestDispatcher("TableroSolucion.jsp");
			vista.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
