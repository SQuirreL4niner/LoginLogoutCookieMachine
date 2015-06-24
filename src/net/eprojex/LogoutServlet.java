package net.eprojex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		
		rs.setContentType("text/html");
		PrintWriter pw = rs.getWriter();
		
		rq.getRequestDispatcher("link.html");
		
		Cookie cook = new Cookie("name","");
		cook.setMaxAge(0);
		rs.addCookie(cook);
		
		pw.print("you are successfully logged out!! Come back soon");
		
	
	}

}
