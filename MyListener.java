import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class MyListener implements HttpSessionListener,ServletContextListener
{
	public void sessionCreated(HttpSessionEvent e)
	{
		HttpSession session=e.getSession();
		//session.setMaxInactiveInterval(20);
	}
	public void sessionDestroyed(HttpSessionEvent e)
	{
		System.out.println("Session destroying...");
		HttpSession session=e.getSession();
		ServletContext ctx=session.getServletContext();
		String userid=(String)session.getAttribute("userid");
		String pass=(String)session.getAttribute("pass");
		System.out.println(userid+""+pass);
		try{
			Connection c=(Connection)ctx.getAttribute("con");
			Statement s=c.createStatement();
			s.executeUpdate("update cust set loginstatus='F' where userid='"+userid+"'and pass='"+pass+"'");
			}catch(Exception ea){System.out.println(ea);}
	}
	public void contextInitialized(ServletContextEvent e)
	{
		try{
			ServletContext ctx=e.getServletContext();
			String driver=ctx.getInitParameter("driver");
			String user=ctx.getInitParameter("user");
			String pass1=ctx.getInitParameter("pass");
			String url=ctx.getInitParameter("url");
			Class.forName(driver);
			Connection c=DriverManager.getConnection(url,user,pass1);
			ctx.setAttribute("con",c);
			System.out.println("Context created");
			}catch(Exception ee){System.out.println(ee);}
	}
	public void contextDestroyed(ServletContextEvent e)
	{}
}