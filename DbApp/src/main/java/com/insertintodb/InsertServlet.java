package com.insertintodb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class InsertServlet extends HttpServlet{
	
	public void service(ServletRequest request, ServletResponse response)
	{
		try {
			
			int rno = Integer.parseInt(request.getParameter("rno"));
			String name = request.getParameter("name");
			int marks = Integer.parseInt(request.getParameter("marks"));
		//	Class.forName("com.mysql.jdbc.Driver");
		    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		    
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		    
		    Statement st = con.createStatement();
		    
		    String query = "insert into student.student2 values("+rno+",'"+name+"',"+marks+")";
		    System.out.println(query);
		    st.executeUpdate(query);
		    
		    PrintWriter out = response.getWriter();
		    response.setContentType("text/html");
		    out.println("records inserted");
		    con.close();
		    

		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		} /*
			 * catch (ClassNotFoundException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
	}

}
