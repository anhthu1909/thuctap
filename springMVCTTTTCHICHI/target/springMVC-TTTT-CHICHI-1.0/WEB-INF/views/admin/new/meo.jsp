<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 7/26/2021
  Time: 2:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String doituong1=request.getParameter("final");
    //String age =request.getParameter("tuoi");
    //out.println(doituong1 + name + age);

    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SYSTEM","Anhthu135@");
        PreparedStatement ps = conn.prepareStatement("insert into SURVEYFORM(CONTENT) values (?)");
        ps.setString(1,doituong1);
        //ps.setString(3,age);
        int x = ps.executeUpdate();
        if(x!=0){
           out.print("Đã lưu thành công ");

        }
        else{
            out.print("Lỗi hệ thống");
        }

    }
    catch(Exception e){
        out.print(e);

    }

%>

</body>
</html>
