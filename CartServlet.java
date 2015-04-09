import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class CartServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			String []watches=(String [])session.getAttribute("watche");
			String []cars=(String [])session.getAttribute("car");
			String []mobiles=(String [])session.getAttribute("mobile");
			String []laptops=(String [])session.getAttribute("laptop");
			String []men=(String [])session.getAttribute("men");
			String []women=(String [])session.getAttribute("women");	
			out.print("<html><body>");
			out.print("<table bgcolor='yellow' border='1' width='400'>");
			if(mobiles!=null)
			{
				out.print("<tr>");
				for(int i=0;i<mobiles.length;i++)
				{
					out.print("<td>"+mobiles[i]+"</td>");
					out.print("</tr>");
				}
			}
			if(laptops!=null)
			{
				out.print("<tr>");
				for(int i=0;i<laptops.length;i++)
				{
					out.print("<td>"+laptops[i]+"</td>");
					out.print("</tr>");
				}
			}
			if(cars!=null)
			{
				out.print("<tr>");
				for(int i=0;i<cars.length;i++)
				{
					out.print("<td>"+cars[i]+"</td>");
					out.print("</tr>");
				}
			}
			if(watches!=null)
			{
				out.print("<tr>");
				for(int i=0;i<watches.length;i++)
				{
					out.print("<td>"+watches[i]+"</td>");
					out.print("</tr>");
				}
			}
			if(men!=null)
			{
				out.print("<tr>");
				for(int i=0;i<men.length;i++)
				{
					out.print("<td>"+men[i]+"</td>");
					out.print("</tr>");
				}
			}
			if(women!=null)
			{
				out.print("<tr>");
				for(int i=0;i<women.length;i++)
				{
					out.print("<td>"+women[i]+"</td>");
					out.print("</tr>");
				}
			}
			out.print("</table>");
			out.print("<br><br><a href='netbank.html'><input type='submit' value='buy now'/></a>");
			out.print("<br><br><a href='welcome.html'><input type='submit' value='back'/></a>");
		}else{
			RequestDispatcher rd=req.getRequestDispatcher("/index.html");
			rd.forward(req,res);
			}
	}
}	