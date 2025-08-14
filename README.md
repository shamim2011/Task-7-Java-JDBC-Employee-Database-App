***1.Package and Imports***  

  
package jdbc_fetch_sql_1;  
import java.sql.*;  
import java.util.*;  

  
You placed the class inside a package jdbc_fetch_sql_1.  

Imported:  

java.sql.* → For JDBC classes (Connection, PreparedStatement, ResultSet, etc.).  

java.util.* → For Scanner (to take user input).  

***2.Main Method — Connection Setup & Menu***  
String url="jdbc:mysql://localhost:3306/myjdbcdb1";  
String username="root";  
String password="samim@25037samim@250370000";  


You set up database connection details.  

Database: myjdbcdb1 (must already exist in MySQL).  

Credentials: MySQL username & password.  

Connection con=DriverManager.getConnection(url,username,password);  
System.out.println("Connection is establishment");  


DriverManager.getConnection(...) establishes a connection to MySQL.  

If successful, prints "Connection is establishment".  

User chooses an operation:  

System.out.println("Enter your choice:");  
int choice=sc.nextInt();  


Takes a number from the user to decide which CRUD operation to perform.  

Switch case:  

switch(choice) {  
    case 1: insert(con); break;
  case 2: update(con); break;  
  case 3: delete(con); break;  
  case 4: fetchData(con); break;  
}  


Based on choice:  

Insert new employee.  

Update existing employee name.  
 
Delete employee.  

Fetch employee by ID.  


***3.insert(Connection con)***  
String query="insert into employee values(?,?,?)";  
Uses a prepared statement with 3 placeholders for:  
emp_id (integer)  
name (string)  
salary (integer)  
PreparedStatement pstmt=con.prepareStatement(query);  
pstmt.setInt(1, emp_id);  
pstmt.setString(2, name);  
pstmt.setInt(3, salary);  
pstmt.execute();  
Sets values in placeholders and executes.  
After inserting, calls fetchData(con) to show the newly inserted record.  


***4.update(Connection con)***  
String query="update employee set name=? where emp_id=?";  
Updates only the name of an employee with the given emp_id.  
pstmt.setString(1, name);  
pstmt.setInt(2, emp_id);  
pstmt.executeUpdate();  
Runs the update, then calls fetchData(con) to display updated record.  
***5.delete(Connection con)***  
String query="delete from employee where emp_id=?";  
Deletes the record for the given employee ID.  
pstmt.setInt(1, emp_id);  
pstmt.executeUpdate();  
Runs deletion, then calls fetchData(con) (although after deletion, it might not show anything).  
***6.fetchData(Connection con)***  
String query="select * from employee where emp_id=?";  
Retrieves a record based on emp_id.  
ResultSet rs = pstmt.executeQuery();  
while(rs.next()) {  
  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));  
}  
Prints emp_id, name, and salary.  
***7.Overall Flow***  
Connect to MySQL DB.  
Ask user for a choice (Insert, Update, Delete, Fetch).  
Perform the chosen operation.  
After each modification, display the affected employee data.  


***8.Strengths***  
✅ Uses PreparedStatement — avoids SQL injection.  
✅ Modular methods (insert, update, delete, fetchData).  
✅ Each CRUD operation is interactive with the user.  
***9.Things You Could Improve***  
Close resources: ResultSet, PreparedStatement, and Connection should be closed in a finally block or use try-with-resources.  
Avoid multiple Scanner objects — create only one and pass it to methods.  
Show all employees after insert/delete instead of asking for emp_id every time in fetchData.  
Handle invalid menu choices with a default case.  

