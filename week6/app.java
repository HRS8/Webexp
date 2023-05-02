CREATE TABLE student(
id INT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
29
age INT,
gender VARCHAR(10),
address VARCHAR(100),
salary DOUBLE
);
import java.sql.*;
public class StudentDatabase {
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost/mydatabase";
static final String USER = "root";
static final String PASS = "password";
public static void main(String[] args) {
Connection conn = null;
Statement stmt = null;
try {
// Register JDBC driver
Class.forName(JDBC_DRIVER);
// Open a connection
conn = DriverManager.getConnection(DB_URL, USER, PASS);
// Insert a record
String insertSql = "INSERT INTO Student (id, name, age, gender, email, phone) VALUES
(1, 'sita’, 15, 'female', 'sita@example.com', '555-12894')";
stmt.executeUpdate(insertSql);
String insertSql = "INSERT INTO Student (id, name, age, gender, email, phone) VALUES
(2, 'ram’, 12, 'male', 'ram@example.com', '555-12874')";
stmt.executeUpdate(insertSql);
String insertSql = "INSERT INTO Student (id, name, age, gender, email, phone) VALUES
(3, 'akanksha’, 15, 'female', 'akanksha@example.com', '555-125434')";
stmt.executeUpdate(insertSql);
30
String updateSql = "UPDATE Student SET age = 19 WHERE id = 1";
stmt.executeUpdate(updateSql);
String deleteSql = "DELETE FROM Student WHERE id = 1";
stmt.executeUpdate(deleteSql);
String selectSql = "SELECT * FROM Student";
ResultSet rs = stmt.executeQuery(selectSql);
while (rs.next()) {
int id = rs.getInt("id");
String name = rs.getString("name");
int age = rs.getInt("age");
String gender = rs.getString("gender");
String email = rs.getString("email");
String phone = rs.getString("phone");
System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " +
gender + ", Email: " + email + ", Phone: " + phone);
}
// Clean-up environment
rs.close();
stmt.close();
conn.close();
} catch(SQLException se) {
// Handle errors for JDBC
se.printStackTrace();
}