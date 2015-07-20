<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>List</title>
</head>
<body>

    <table border=1>
        <thead>
            <tr>
                <th>Name</th>
                <th>Date</th>
                <th>Inward</th>
                <th>Accepted</th>
                <th>Rejected</th>
                <th>Closing Stock </th>
                <th>Vendor</th> 
             
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${rawMaterials}" var="rawMaterial" >
            	<form method="post" action="RejectionServlet">
              <tr>
                	<td> <input type="text" readonly="readonly" name="rawmaterial"
           							 value="<c:out value="${rawMaterial.name}" />" /> </td>	
                   	<td><input type="text" name="date"
            						value="<fmt:formatDate pattern="yyyy-MM-dd" value="${rawMaterial.date}" />" />
            		<td> <input type="text" readonly="readonly" name="inward"
           							 value="<c:out value="${rawMaterial.inward}" />" /> </td>				
                    <td> <input type="text" readonly="readonly" name="accepted"
           							 value="<c:out value="${rawMaterial.accepted}" />" /> </td>	
                    <td> <input type="text" readonly="readonly" name="rejected"
           							 value="<c:out value="${rawMaterial.rejected}" />" /> </td>	
                   <td> <input type="text" readonly="readonly" name="closing_stock"
           							 value="<c:out value="${rawMaterial.closing_stock}" />" /> </td>
           		   <td> <input type="text" readonly="readonly" name="vendor"
           							 value="<c:out value="${rawMaterial.vendor}" />" /> </td>		
                </tr>
               </form>
            </c:forEach>
        </tbody>
    </table>
 
</body>
</html>