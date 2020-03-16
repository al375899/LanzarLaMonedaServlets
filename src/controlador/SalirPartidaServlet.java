package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SalirPartidaServlet")
public class SalirPartidaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SalirPartidaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			HttpSession sesion = request.getSession(false); // Coger la sesion, si existe

			if (sesion != null) {
				sesion.invalidate();
			}

			response.sendRedirect("index.html");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}