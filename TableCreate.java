import java.sql.*;
import java.util.*;
import java.io.*;
public class TableCreate
{
	public static void createTab(String path)
	{
		try{
			FileInputStream fin=new FileInputStream(path);
			byte[] br=new byte[fin.available()];
			fin.read(br);
			fin.close();
			String data=new String(br);
			StringTokenizer str=new StringTokenizer(data,"/");
			Connection con=ConnectionProvider.getConn();
			Statement st=con.createStatement();
			while(str.hasMoreTokens())
			{
				String query=str.nextToken();
				if(query.trim().equals("stop"))
				{
					break;
				}
				st.executeUpdate(query);
				System.out.println(query);
			}
		}catch(Exception e){}
	}
}



