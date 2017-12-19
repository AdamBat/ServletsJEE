package pl.coderslab;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Post3")
public class Post3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Post3() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		double a = Double.parseDouble(request.getParameter("a"));
		double b = Double.parseDouble(request.getParameter("b"));
		double c = Double.parseDouble(request.getParameter("c"));
		double delta = (Math.pow(b, 2)) - 4 * (a * c);
		if (delta > 0) {
			double x1 = (-b + Math.sqrt(delta)) / (2 * a);
			double x2 = (-b - Math.sqrt(delta)) / (2 * a);
			writer.println("Dwa miejsca zerowe:" + x1 + " " + x2);
		} else if (delta == 0) {
			double x = (-b) / 2 * a;
			writer.println("Jedno miejsce zerowe x=" + x);
		} else {
			writer.println("Brak miejsc zerowych");
		}

	}

}
