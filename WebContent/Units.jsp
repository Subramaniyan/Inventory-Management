<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    
    <form method="post" action="MasterServlet" >
    <label> Unit Name </label>
    <input type="text" name="unitName"> <br/>
    <label> Unit </label>
    <input type="text" name="unit"> <br/>
    <input type="submit" value="Insert"> 
    </form>

</body>
</html>