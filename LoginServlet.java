import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class LoginServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		String userid=req.getParameter("userid");
		String pass=req.getParameter("pass");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		try{
			 HttpSession session=req.getSession();
			session.setAttribute("userid",userid);
			session.setAttribute("pass",pass);
		}catch(Exception e){out.println(e);}
	}
}