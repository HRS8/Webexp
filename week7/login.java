import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;32
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class Login extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String name = request.getParameter("username");
String password = request.getParameter("password");
try {
Class.forName("com.mysql.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/javalab","root","Password@123
");
Statement stmt = con.createStatement();
String query = "Select * from details where name = '"+ name+"' and password =
'"+ password +"'";
ResultSet rs = stmt.executeQuery(query);
if(rs.next()){
out.print("Welcome to you "+name);
}else{
out.print("Sorry Incorrect Entry");
}} catch (Exception e) {
out.write("Error in JDBC connectivity : "+e);}}
}Index.html<!DOCTYPE html><html><head><title>Login Page</title>33</head><body><center><b><
p style = "font-size:x-large;" >Student Login Page</p></b><
form action = "Login"method="post"><label>Name:</label><
input type = "text"name="username"id="username"><br><br><label>Password:</label><
input type = "text"name="password"id="password"><br><br><input type="submit"></input>
</form>
</center>
</body>
</html>