<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>

<html>
<head>
<link rel="stylesheet" href="style.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script src="jquery.js"></script>
<script src="bootstrap.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Welcome <%=session.getAttribute("name")%></title>  
</head>
<body>

 	<h4>  
        Hello,  
        <%=session.getAttribute("name")%> !
    </h4>  
    
    <%
   Connection con= null;
   PreparedStatement ps = null;
   ResultSet rs = null;
   String driverName = "com.mysql.jdbc.Driver";
   String url = "jdbc:mysql://localhost:3306/inventory";
   String user = "root";
   String password = "killer";
   String st=null;
   String sql = "select unit from units";
   Statement state;
   
   try {
	   Class.forName(driverName);
	   con = DriverManager.getConnection(url, user, password);
	   ps = con.prepareStatement(sql);
	   rs = ps.executeQuery();
	%>
    
    <form method="post" action="MasterRawServlet" >
    <label> Name </label>
    <input type="text" name="name"> <br/>
    <label> Unit </label>
    <select name="unit">
	<option value="select">Select the unit</option>
	
	<%
	while(rs.next()){

		String unitType = rs.getString("unit");
	%>

	<option value=<%=unitType%>><%=unitType%></option>

	<% 
	}
	} catch( SQLException ex ){
	out.println(ex);
	}
	%>
	
	</select> <br/>
	<label> Category </label>
	<select name="category">
	<option value="select">Select the category</option>
	<option value="ClassA"> ClassA </option>
	<option value="ClassB"> ClassB </option>
	<option value="ClassC"> ClassC </option>
	</select>
    <input type="submit" value="Insert"> 
    </form>

</body>
</html>