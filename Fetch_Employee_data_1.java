package jdbc_fetch_sql_1;

import java.sql.*;
import java.util.*;

public class Fetch_Employee_data_1 {

	
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/myjdbcdb1";
		String username="root";
		String password="samim@25037samim@250370000";
		Scanner sc=new Scanner(System.in);
		
		try {
			// 3 . Connection is established
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("Connection is establishment");
			
			//Scanner sc=new Scanner(System.in);
			System.out.println("Enter your choice:");
			int choice=sc.nextInt();
			switch(choice) {
			case 1: 
				insert(con);
				break;
			case 2:
				update(con);
				break;
			case 3:
				delete(con);
				break;
			case 4:
				fetchData(con);
				break;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	public static void insert(Connection con) throws Exception{
		
		String query="insert into employee values(?,?,?)";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the employee id:");
		int emp_id=sc.nextInt();
		System.out.println("Enter the employee name:");
		String name=sc.next();
		System.out.println("Enter the employee salary:");
		int salary=sc.nextInt();
		
		PreparedStatement pstmt=con.prepareStatement(query);
		
		pstmt.setInt(1, emp_id);
		pstmt.setString(2, name);
		pstmt.setInt(3, salary);
		
		pstmt.execute();
		
		System.out.println("Rows are inserted");
		fetchData(con);
	}
	public static void update(Connection con) throws Exception{
		String query="update employee set name=? where emp_id=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the employee name:");
		String name=sc.next();
		System.out.println("Enter the employee id:");
		int emp_id=sc.nextInt();
		
		PreparedStatement pstmt=con.prepareStatement(query);
		   
		pstmt.setString(1, name);
		pstmt.setInt(2, emp_id);
		
		pstmt.executeUpdate();
		
		System.out.println("Rows are updated");
		fetchData(con);
	}
	public static void delete(Connection con) throws Exception{
		String query="delete from employee where emp_id=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the employee id:");
		int emp_id=sc.nextInt();
		
		PreparedStatement pstmt=con.prepareStatement(query);
		
		pstmt.setInt(1, emp_id);
		
		pstmt.executeUpdate();
		
		System.out.println("Rows are deleted");
		fetchData(con);
	}
	public static void fetchData(Connection con) throws Exception{
		String query="select * from employee where emp_id= ?";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the employee id:");
		int emp_id=sc.nextInt();
		PreparedStatement pstmt=con.prepareStatement(query);
		
		pstmt.setInt(1, emp_id);
		ResultSet rs =pstmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}
		
	}
}
