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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<hmtl><body>");
		out.println("<h2>Ergebnis: </>");
		out.println("<textarea name='text' rows=\"\" cols=\"\">");
		response.getWriter().print(ergebnis);
		out.println("</textarea>" + "<script>\r\n"
				+ "    document.write('<a href=\"' + /solver.jsp + '\">Go Back</a>');\r\n" + "</script>");
		out.println("<hmtl><body>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String button = request.getParameter("button");
		String iter = request.getParameter("iterations");
		String crossover = request.getParameter("radioCross");
		String selection = request.getParameter("radioSelection");
		Integer iterations;
		try {
			iterations = Integer.parseInt(iter);
		} catch (NumberFormatException e) {
			iterations = 0;
		}
		if ("buttonCalc".equals(button)) {
			GA einGA = new GA();
			for (int g = 0; g < (int) iterations; g++) {
				if (crossover.equals("onepoint")) {
					einGA.onePointCrossover();
				} else {
					einGA.uniformCrossover();
				}
				einGA.flipMutation();
				if (selection.equals("rankrep")) {
					einGA.selectionRankReplacement(2);// Dekodieren
				} else {
					einGA.selectionGenReplacement();
				}
			}
			ergebnis = einGA.besteFitness;
		}
		doGet(request, response);
	}

}
