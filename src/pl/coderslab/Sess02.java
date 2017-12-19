package pl.coderslab;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Sess02
 */
@WebServlet("/Sess02")
public class Sess02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Sess02() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sess = request.getSession();
		int grade = Integer.parseInt(request.getParameter("grade"));
		int[] grades = (int[]) sess.getAttribute("grades");
		if (grade > 0 && grade < 7) {
			if (sess.getAttribute("grades") == null) {
				grades = new int[] { grade };
			} else {
				grades = addToGrades(grades, grade);
			}
			sess.setAttribute("grades", grades);

		}
		response.getWriter().append(Arrays.toString(grades));
		if (grades != null) {
			response.getWriter().append("Avg = " + countAvg(grades));

		}

	}

	private double countAvg(int[] grades) {
		double sum = Arrays.stream(grades).sum();
		return sum / grades.length;
	}

	public int[] addToGrades(int[] grades, int grade) {
		int[] tmpGrades = Arrays.copyOf(grades, grades.length + 1);
		tmpGrades[grades.length] = grade;
		return tmpGrades;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

}
