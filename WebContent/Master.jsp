<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>
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
        
   <div id=head>

<div class="tab">
    <ul class="nav nav-tabs">
        <li><a href="Units.jsp"> UNITS </a></li>
 		<li><a  href="RawMaterialInsert.jsp"> RAW MATERIALS </a></li> 
 		<li><a  href="Bom.jsp"> BOM </a></li>   
    </ul>
</div>
</div>
</body>
</html> 