package misFiltros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FiltroStockRemeras
 */
@WebFilter("/seleccionDePartido")
public class FiltroStockRemeras extends HttpFilter implements Filter {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public FiltroStockRemeras() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
    
    public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String seleccion = request.getParameter("seleccion");
		ServletContext context = request.getServletContext();
		//System.out.println("dentro del filtro 2" + seleccion);
		int cantCamisetas = (int) context.getAttribute(seleccion);
		System.out.println("cantidad camisetas " + cantCamisetas);
		if(cantCamisetas != 0) {
			chain.doFilter(request, response);
		}
		((HttpServletResponse) response).sendRedirect("error.html");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
