package net.eprojex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		 rs.setContentType("text/html");
		 PrintWriter pw = rs.getWriter();
		 
		 rq.getRequestDispatcher("link.html").include(rq, rs);
		 
		 Cookie cook[] = rq.getCookies();
		 if(cook != null) {
			 String name = cook[0].getValue();
			 if(!name.equals("") || name!=null) {
				 pw.print("<b>Welcome to your profile page!!</b>");
				 pw.print("<br>Welcome, " + name);
			 } 
		 }else {
				 pw.print("Please login first!!");
				 rq.getRequestDispatcher("login.html").include(rq, rs);
			 }
			 
			 pw.close();
		 }
	}


