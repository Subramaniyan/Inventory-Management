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
   Statement state;
   
   try {
	   Class.forName(driverName);
	   con = DriverManager.getConnection(url, user, password);
	   ps = con.prepareStatement("select unit from  units");
	   rs = ps.executeQuery();
	%>
    
    <form method="post" action="MasterWIPServlet" >
    <label> Name </label>
    <input type="text" name="name"> <br/>
    <label> Part NO </label>
     <input type="text" name="partNo"> <br/>
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
	 <label> BOM </label> <br/><br/>
	 
	 <label> Raw Material 1</label><br/>
	 <label> Name </label>
     <select name="drop1">
	<option></option>
	
	<%
	try {
	ps = con.prepareStatement("select name from  raw_db");
	rs = ps.executeQuery();
	while(rs.next()){

		String unitType = rs.getString("name");
	%>

	<option value=<%=unitType%>><%=unitType%></option>

	<% 
	}
	ps = con.prepareStatement("select name from  process");
	rs = ps.executeQuery();
	while(rs.next()){

		String unitType = rs.getString("name");
		%>
		
	<option value=<%=unitType%>><%=unitType%></option>	
	
	<%
	}
	} catch( SQLException ex ){
	out.println(ex);
	}
	%>
	
	</select> <br/>
	 <label> Quantity </label>
     <input type="text" name="raw1"> <br/>
	
	 <label> Raw Material 2</label><br/>
    <label> Name </label>
     <select name="drop2">
	<option ></option>
	
	<%
	try {
	ps = con.prepareStatement("select name from  raw_db");
	rs = ps.executeQuery();
	while(rs.next()){

		String unitType = rs.getString("name");
	%>

	<option value=<%=unitType%>><%=unitType%></option>

	<% 
	}
	ps = con.prepareStatement("select name from  process");
	rs = ps.executeQuery();
	while(rs.next()){

		String unitType = rs.getString("name");
		%>
		
	<option value=<%=unitType%>><%=unitType%></option>	
	
	<%
	}
	} catch( SQLException ex ){
	out.println(ex);
	}
	%>
	
	</select> <br/>
	<label> Quantity </label>
     <input type="text" name="raw2"> <br/>
	
	 <label> Raw Material 3</label><br/>
     <label> Name </label>
     <select name="drop3">
	<option ></option>
	
	<%
	try {
	ps = con.prepareStatement("select name from  raw_db");
	rs = ps.executeQuery();
	while(rs.next()){

		String unitType = rs.getString("name");
	%>

	<option value=<%=unitType%>><%=unitType%></option>

	<% 
	}
	ps = con.prepareStatement("select name from  process");
	rs = ps.executeQuery();
	while(rs.next()){

		String unitType = rs.getString("name");
		%>
		
	<option value=<%=unitType%>><%=unitType%></option>	
	
	<%
	}
	} catch( SQLException ex ){
	out.println(ex);
	}
	%>
	
	</select> <br/>
	 <label> Quantity </label>
     <input type="text" name="raw3"> <br/>
	
	 <label> Raw Material 4</label>
    <label> Name </label>
     <select name="drop4">
	<option></option>
	
	<%
	try {
	ps = con.prepareStatement("select name from  raw_db");
	rs = ps.executeQuery();
	while(rs.next()){

		String unitType = rs.getString("name");
	%>

	<option value=<%=unitType%>><%=unitType%></option>

	<% 
	}
	ps = con.prepareStatement("select name from  process");
	rs = ps.executeQuery();
	while(rs.next()){

		String unitType = rs.getString("name");
		%>
		
	<option value=<%=unitType%>><%=unitType%></option>	
	
	<%
	}
	} catch( SQLException ex ){
	out.println(ex);
	}
	%>
	
	</select> <br/>
	<label> Quantity </label>
     <input type="text" name="raw4" > <br/>
	
	<label> Raw Material 5</label><br/>
    <label> Name </label>
     <select name="drop5">
	<option></option>
	
	<%
	try {
	ps = con.prepareStatement("select name from  raw_db");
	rs = ps.executeQuery();
	while(rs.next()){

		String unitType = rs.getString("name");
	%>

	<option value=<%=unitType%>><%=unitType%></option>

	<% 
	}
	ps = con.prepareStatement("select name from  process");
	rs = ps.executeQuery();
	while(rs.next()){

		String unitType = rs.getString("name");
		%>
		
	<option value=<%=unitType%>><%=unitType%></option>	
	
	<%
	}
	} catch( SQLException ex ){
	out.println(ex);
	}
	%>
	
	</select> <br/>
	<label> Quantity </label>
     <input type="text" name="raw5" > <br/>
     
     
    <input type="submit" value="Insert"> 
    </form>

</body>
</html>