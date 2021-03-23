package com.priyasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp06 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
	        st= con.createStatement();
	        int rowCount1=st.executeUpdate("Create table emp3(eno number(3),ename varchar(20))");
	        System.out.println("RowCount for Create:"+rowCount1);
	        int rowCount2=st.executeUpdate("drop table emp2");
	        System.out.println("RowCount for Drop:"+rowCount2);
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{ 
			try
			{
			st.close();
			con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
