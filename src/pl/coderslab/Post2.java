package pl.coderslab;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Post2
 */
@WebServlet("/Post2")
public class Post2 extends HttpServlet {
	String[] swears = { "chuj", "chuja", "chujek", "chuju", "chujem", "chujnia", "chujowy", "chujowa", "chujowe",
			"cipa", "cipę", "cipe", "cipą", "cipie", "dojebać", "dojebac", "dojebie", "dojebał", "dojebal", "dojebała",
			"dojebala", "dojebałem", "dojebalem", "dojebałam", "dojebalam", "dojebię", "dojebie", "dopieprzać",
			"dopieprzac", "dopierdalać", "dopierdalac", "dopierdala", "dopierdalał", "dopierdalal", "dopierdalała",
			"dopierdalala", "dopierdoli", "dopierdolił", "dopierdolil", "dopierdolę", "dopierdole", "dopierdoli",
			"dopierdalający", "dopierdalajacy", "dopierdolić", "dopierdolic", "dupa", "dupie", "dupą", "dupcia",
			"dupeczka", "dupy", "dupe", "huj", "hujek", "hujnia", "huja", "huje", "hujem", "huju", "jebać", "jebac",
			"jebał", "jebal", "jebie", "jebią", "jebia", "jebak", "jebaka", "jebal", "jebał", "jebany", "jebane",
			"jebanka", "jebanko", "jebankiem", "jebanymi", "jebana", "jebanym", "jebanej", "jebaną", "jebana", "jebani",
			"jebanych", "jebanymi", "jebcie", "jebiący", "jebiacy", "jebiąca", "jebiaca", "jebiącego", "jebiacego",
			"jebiącej", "jebiacej", "jebia", "jebią", "jebie", "jebię", "jebliwy", "jebnąć", "jebnac", "jebnąc",
			"jebnać", "jebnął", "jebnal", "jebną", "jebna", "jebnęła", "jebnela", "jebnie", "jebnij", "jebut", "koorwa",
			"kórwa", "kurestwo", "kurew", "kurewski", "kurewska", "kurewskiej", "kurewską", "kurewska", "kurewsko",
			"kurewstwo", "kurwa", "kurwaa", "kurwami", "kurwą", "kurwe", "kurwę", "kurwie", "kurwiska", "kurwo",
			"kurwy", "kurwach", "kurwami", "kurewski", "kurwiarz", "kurwiący", "kurwica", "kurwić", "kurwic",
			"kurwidołek", "kurwik", "kurwiki", "kurwiszcze", "kurwiszon", "kurwiszona", "kurwiszonem", "kurwiszony",
			"kutas", "kutasa", "kutasie", "kutasem", "kutasy", "kutasów", "kutasow", "kutasach", "kutasami",
			"matkojebca", "matkojebcy", "matkojebcą", "matkojebca", "matkojebcami", "matkojebcach", "nabarłożyć",
			"najebać", "najebac", "najebał", "najebal", "najebała", "najebala", "najebane", "najebany", "najebaną",
			"najebana", "najebie", "najebią", "najebia", "naopierdalać", "naopierdalac", "naopierdalał", "naopierdalal",
			"naopierdalała", "naopierdalala", "naopierdalała", "napierdalać", "napierdalac", };
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Post2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String text = request.getParameter("tekst");
		String[] textArray = text.split(" ");

		if (request.getParameter("check") == null) {
			for (int i = 0; i < textArray.length; i++) {
				for (int j = 0; j < swears.length; j++) {
					if (textArray[i].equals(swears[j])) {
						String word = "";
						for (int k = 0; k < textArray[i].length(); k++) {
							word += "*";

						}
						textArray[i] = word;
					}

				}

			}
			String corrected = Arrays.toString(textArray);
			writer.println(corrected);
		} else {
			writer.println(text);
		}
	}

}
