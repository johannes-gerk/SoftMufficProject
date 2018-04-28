package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet(name = "Servlet", urlPatterns = { "/Servlet" })
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private float ergebnis;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<hmtl><body>");
		out.println("<h2>Ergebnis: </>");
		out.println("<textarea name='text' rows=\"\" cols=\"\">");
		response.getWriter().print(ergebnis);
		out.println("</textarea>"
				+ "<script>\r\n" + 
				"    document.write('<a href=\"' + /Servlet + '\">Go Back</a>');\r\n" + 
				"</script>");
		out.println("<hmtl><body>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String button = request.getParameter("button");
		String iter = request.getParameter("iterations");
		Integer iterations = Integer.parseInt(iter);
		if ("buttonCalc".equals(button)) {
			GA einGA = new GA();
			for (int g = 0; g < (int)iterations; g++) {
				einGA.rekombinieren();// selektion
				einGA.mutieren();
				einGA.bewerten();// DEkodieren
			}
			ergebnis = einGA.besteFitness;
		}
		doGet(request, response);
	}

}
