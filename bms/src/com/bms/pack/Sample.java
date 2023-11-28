package com.bms.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Sample {
static Scanner s=new Scanner(System.in);
static String url="jdbc:mysql://localhost:3306/bms";
	static  String user="root";
	static String pass="santhosh@123";	

	public static void main(String[] args) throws ClassNotFoundException, SQLException { 
		
		int i=1;
		while (true)
		{
			menu();
			System.out.println("enter your choice");
			int c=s.nextInt();
			switch (c) {
			case 1: System.out.println("open account");
			        open_acc();
			        break;
			case 2 : System.out.println("deposite");
	                 deposit_money();
	                   break;
			case 3: System.out.println("withdraw money");
			        withdraw();
	                break;
			case 4: System.out.println("balance enquire");
	                 bal_enq();
	                 break;
			case 5: System.out.println("view all the profile");
	                   view();
	                   break;
			case 6: System.out.println("close the account");
	                  close_acc();
	                   break;
			case 7:  System.out.println("         Execution has been Stopped");
			System.out.println("--------------*-----------*---------------");
			System.exit(c);
	                    break;
			 default :System.out.println("enter valid option");
				 break;       
			}
		}
		}
		
		
	

	private static void close_acc() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");				
		Connection c=DriverManager.getConnection(url,user,pass);
		String query="DELETE FROM account WHERE acc_no = ?";
		PreparedStatement ps=c.prepareStatement(query);
		System.out.println("enter your acc_no");
		int  acc_no=s.nextInt();
		ps.setInt(1, acc_no);
		ps.executeUpdate();
		System.out.println("Your account has been deleted");
		c.close();
		
	}

	private static void view() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");	
	Connection c=DriverManager.getConnection(url,user,pass);		
	System.out.println("enter the account number ");
	int acc_no=s.nextInt();
	String query="select acc_no,name,phone,dob,addrs from account where acc_no="+acc_no;
	Statement st=c.createStatement();
	ResultSet rs=st.executeQuery(query);

	while(rs.next())
	{
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getString(5));
	}
		
	}

	private static void bal_enq() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");	
	Connection c=DriverManager.getConnection(url,user,pass);		
	System.out.println("enter the account number ");
	int acc_no=s.nextInt();
	String query="select acc_no, balance from account where acc_no="+acc_no;
	Statement st=c.createStatement();
	ResultSet rs=st.executeQuery(query);

	while(rs.next())
	{
		System.out.println(" account number "+rs.getInt(1)+"   balance  "+rs.getInt(2));
	}
		
	}

	private static void withdraw() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection(url,user,pass);
		System.out.println("enter the account number ");
		int acc_no=s.nextInt();
		System.out.println("enter the withdraw amount");
		int amount=s.nextInt();
		String query="update account set balance=balance-"+amount+"  where acc_no="+acc_no;
		PreparedStatement ps=c.prepareStatement(query);
		ps.executeUpdate(query);
		c.close();
		System.out.println(amount+" has been withdrawn successfully");
	    
	}

	private static void deposit_money()throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection(url,user,pass);
		System.out.println("enter the account number ");
		int acc_no=s.nextInt();
		System.out.println("enter the deposite amount");
		int amount=s.nextInt();
		String query="update account  set balance=balance+"+amount+" where acc_no="+acc_no;
		PreparedStatement ps=c.prepareStatement(query);
		ps.executeUpdate();
		c.close();
		System.out.println(amount+ "has been deposited successfully");
	}

	 static void open_acc() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection(url,user,pass);
		  String q="insert into account values (?,?,?,?,?,?)	";		  
		    PreparedStatement ps=c.prepareStatement(q);
		    System.out.println("enter name");
		    String name =(s.next());
		    System.out.println("enter phone no");
		   int phone =s.nextInt();
		    System.out.println("enter DOB");
		    String dob=s.next();
		    System.out.println("enter address");
		    String addrs=s.next(); 
		    System.out.println("enter account no");
		    int acc_no =s.nextInt();
		    System.out.println("enter opening balance");
		    int open_bal =s.nextInt();
			ps.setString(1, name);
			ps.setInt(2, phone);
			ps.setString(3, dob);
			ps.setString(4, addrs);
			ps.setInt(5, acc_no);
			ps.setInt(6, open_bal);
		    ps.executeUpdate();
	}

	public static void menu()
		{
		System.out.println("*************************");
		System.out.println("*   over sea bank       *");
		System.out.println("*************************");
		System.out.println("*1. open an account     *");
		System.out.println("*2. deposite            *");
		System.out.println("*3. withdraw            *");
		System.out.println("*4. balance enqire      *");
		System.out.println("*5. show the profile    *");
		System.out.println("*6. close an account    *");
		System.out.println("*7. stop the program    *");
		System.out.println("*************************");
		}
}


