package com.yedam.config.JavaTest1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JavaTest1Filter {
   public static void main(String[] args) throws IOException {

	   
	   Connection conn = null;
      String user = "hr";
      String pass = "hr";
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection(url, user, pass);
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }

      
      
      
      List<JavaTestStream> list = new ArrayList<>();
      try {
         PreparedStatement pstmt = conn.prepareStatement("SELECT first_name, salary FROM Employees ORDER BY 1");
         ResultSet rs = pstmt.executeQuery();
         while (rs.next()) {
            list.add(new JavaTestStream(rs.getString("first_name"), rs.getInt("salary")));
         }
      } catch (SQLException e) {
         System.out.println(".확인.");
      }
      Stream<JavaTestStream> stream = list.stream();
      stream.filter(s -> s.getSalary() >= 1000)
            .forEach((s) -> System.out.println(s.getFirstName() + ", " + s.getSalary()));

   }

}