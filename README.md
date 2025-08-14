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
