package net.eprojex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		rs.setContentType("text/html");
		PrintWriter pw = rs.getWriter();
		
		rq.getRequestDispatcher("link.html").include(rq, rs);
		
		String name = rq.getParameter("name");
		String password = rq.getParameter("password");
		
		if(password.equals("admin123")) {
			pw.print("You are successfully logged in!!! Rejoice");
			pw.print("<br>Welcome, " + name);
			
			Cookie cook = new Cookie("name", name);
			rs.addCookie(cook);
		} else {
			pw.print("sorry, username and/or password error!");
			rq.getRequestDispatcher("login.html").include(rq, rs);
		}
		
		pw.close();
	}

}
