package misServlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImprimeCupon
 */
@WebServlet("/ImprimeCupon")
public class ImprimeCupon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImprimeCupon() {
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
		String textoPersonalizado = request.getParameter("texto");
		String texto = getServletContext().getInitParameter(request.getParameter("seleccion"));
		int codigo = ThreadLocalRandom.current().nextInt(1000000,99999999);
		
		OutputStream outputStream = response.getOutputStream();
		
		BufferedImage image = new BufferedImage(1800, 1200, BufferedImage.TYPE_INT_BGR);
		Graphics2D graphics = image.createGraphics();
		BufferedImage img = ImageIO.read(this.getServletContext().getResourceAsStream("/WEB-INF/camiseta.jpg"));
		graphics.setBackground(Color.WHITE);
		graphics.clearRect(0, 0, 1800,1200);
		graphics.drawImage(img, 40, 80, null, null);
		graphics.setFont(new Font("TimesRoman", Font.BOLD, 30));
		graphics.setColor(Color.white);
		graphics.drawString("Yo estuve en", 490, 500);
		graphics.drawString(texto, 450, 600);
		graphics.drawString(textoPersonalizado, 550, 750);
		graphics.drawString("Código de Retiro " + codigo, 1200, 550);
		javax.imageio.ImageIO.write(image, "png", outputStream);
		outputStream.close();
		
	}

}
