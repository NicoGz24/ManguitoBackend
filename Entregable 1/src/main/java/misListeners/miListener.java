package misListeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class miListener
 *
 */
@WebListener
public class miListener implements ServletContextListener {


    public miListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        int cantCamisetas1 = Integer.parseInt(sce.getServletContext().getInitParameter("camisetas"));
        int cantCamisetas2 = Integer.parseInt(sce.getServletContext().getInitParameter("camisetas"));
        int cantCamisetas3 = Integer.parseInt(sce.getServletContext().getInitParameter("camisetas"));
         sce.getServletContext().setAttribute("Partido1", cantCamisetas1);
         sce.getServletContext().setAttribute("Partido2", cantCamisetas2);
         sce.getServletContext().setAttribute("Partido3", cantCamisetas3);
         //System.out.println("dentro del listener");
    	
    }
	
}
