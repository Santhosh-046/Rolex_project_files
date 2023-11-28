package com.crud_operation.pack;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;
	public class Sample {
         static Scanner s=new Scanner(System.in);
		 static String url="jdbc:mysql://localhost:3306/curd_project";
			static  String user="root";
			static String pass="santhosh@123";
		public static void main(String[] args) throws ClassNotFoundException, SQLException { 
			while (true)
			{
				menu();
				System.out.println("enter your choice");
				int c=s.nextInt();
				switch (c) {
				case 1: System.out.println("insert the value");
				        insert();
				        break;
				case 2 : System.out.println("delete the value ");
		                 delete();
		                   break;
				case 3: System.out.println("display the data");
				view();
		                break;
				case 4: System.out.println("modify the data");
		                 edit();
		                 break;
				case 5: System.out.println("         Execution has been Stopped");
				System.out.println("--------------*-----------*---------------");
				System.exit(c);
				 break;
				 default :System.out.println("enter valid option");
					 break;       
				}
			}
		}
		
	private static void edit()  throws ClassNotFoundException, SQLException 
	{
	Class.forName("com.mysql.cj.jdbc.Driver");	
		Connection c=DriverManager.getConnection(url,user,pass);		
		System.out.println("enter the reg no of the student to be updated");
		int r=s.nextInt();
		String query="select * from student_table where reg_no="+r;
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
		}
		System.out.println("1.update name");
		System.out.println("2.update course");
		System.out.println("3.update marks");
		int choice =s.nextInt();
		switch (choice)
		{
		case 1:System.out.println( "enter new name ");
		String newname=s.next();
		String q= "update student_table set name=? where reg_no="+r;
		PreparedStatement ps=c.prepareStatement(q);
		ps.setString(1, newname);
		int row=ps.executeUpdate();
		if (row>0)
		{
			System.out.println("record updated successfully");
		}
		         break;
		case 2:System.out.println( "enter new course ");
		String newcourse=s.next();
		String q1 = "update student_table set course=? where reg_no="+r;
		PreparedStatement ps1=c.prepareStatement(q1);
		ps1.setString(1, newcourse);
		int row1=ps1.executeUpdate();
		if (row1>0)
		{
			System.out.println("record updated successfully");
		}
		           break;
		case 3:System.out.println( "enter new marks ");
		int newmarks=s.nextInt();
		String q3 = "update student_table set marks=? where reg_no="+r;
		PreparedStatement ps2=c.prepareStatement(q3);
		ps2.setInt(1, newmarks);
		int row2=ps2.executeUpdate();
		if (row2>0)
		{
			System.out.println("record updated successfully");
		}
		     break;
		}	c.close();	
	}
     private static void view() 
			 throws ClassNotFoundException, SQLException 
	{
	Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection c=DriverManager.getConnection(url,user,pass);
		String query="select * from student_table";
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
		}		c.close();
		}
	private static void delete() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.cj.jdbc.Driver");				
				Connection c=DriverManager.getConnection(url,user,pass);
				String query="DELETE FROM student_table WHERE reg_no = ?";
				PreparedStatement ps=c.prepareStatement(query);
				System.out.println("enter your reg_no");
				int reg_no=s.nextInt();
				ps.setInt(1, reg_no);
				int rows=ps.executeUpdate();
				System.out.println("number of rows affected:"+rows);
				c.close();
		}
	private static void insert() throws ClassNotFoundException, SQLException 
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection c=DriverManager.getConnection(url,user,pass);		
		 String q="insert into student_table values (?,?,?,?)	";
		PreparedStatement ps=c.prepareStatement(q);
		System.out.println("enter reg no");
	    int reg_no =s.nextInt();
		System.out.println("enter name");
	    String name =s.next();
	    System.out.println("enter course");
	    String course=s.next();
	    System.out.println("enter marks");
	    int marks=s.nextInt(); 
		ps.setString(2, name);
		ps.setInt(1, reg_no);
		ps.setString(3, course);
		ps.setInt(4, marks);
		 ps.executeUpdate();
		 c.close();
		}
	public static void menu()
	{
	System.out.println("***************************");
	System.out.println("*      curd operation     *");
	System.out.println("***************************");
	System.out.println("*1.        insert         *");
	System.out.println("*2.         delete        *");
	System.out.println("*3.          view         *");
	System.out.println("*4.          edit         *");
	System.out.println("*5.   stop the program    *");
	System.out.println("***************************");
	}	
}