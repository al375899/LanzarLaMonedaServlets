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
@WebServlet("/LanzarLaMonedaServlet")
public class LanzarLaMonedaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LanzarLaMonedaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
			RequestDispatcher vista = request.getRequestDispatcher("Tablero.jsp");
			vista.forward(request, response);
		} catch (

		Exception e) {
			e.printStackTrace();
		}

	}

}
