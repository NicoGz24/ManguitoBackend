package misServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class seleccionDePartido
 */
@WebServlet("/seleccionDePartido")
public class seleccionDePartido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public seleccionDePartido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seleccion = request.getParameter("seleccion");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ImprimeCupon");
		ServletContext contexto = getServletContext();
		int cantCamisetas = (int) contexto.getAttribute(seleccion);
		contexto.setAttribute(seleccion, cantCamisetas-1);
		//System.out.println("dentro del seleccion de partido");
		dispatcher.forward(request, response);
			
	}

}
