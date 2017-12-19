package pl.coderslab;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Post4
 */
@WebServlet("/Post4")
public class Post4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Post4() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Random random = new Random();
		int rand = random.nextInt(5) + 5;
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		writer.append("<form action='Post4' method='post'>");
		for (int i = 0; i <= rand; i++) {
			writer.append("<input name='numbers'/><br/>");
		}
		writer.append("<input type='submit'/></form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String[] params = request.getParameterValues("numbers");
		for (int i = 0; i < params.length; i++) {
			if (params[i].matches("^-?\\d+$")) {
				writer.println(params[i]);
			}

		}

	}

}
