package pl.coderslab;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookie6")
public class Cookie6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Cookie6() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie cookieText = new Cookie("text-color", request.getParameter("text-color"));
		System.out.println(request.getParameter("text-color"));
		Cookie cookieBack = new Cookie("background-color", request.getParameter("background-color"));
		response.addCookie(cookieBack);
		System.out.println(cookieBack.getValue());
		response.addCookie(cookieText);
		System.out.println(cookieText.getValue());
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		writer.append(
				"<div style='background-color:" + cookieBack.getValue() + ";color:" + cookieText.getValue() + "'>");
		writer.append("Wybrales kolor tekstu:" + cookieText.getValue() + " oraz tla:" + cookieBack.getValue());
		writer.append("</div");

	}

}
