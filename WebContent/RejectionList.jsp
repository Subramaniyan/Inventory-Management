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
 <form method="post" action="RejectionServlet">

    <table border=1>
        <thead>
            <tr>
            	<th> </th>
                <th>Name</th>
                <th>Date</th>
                <th>Inward</th>
                <th>Accepted</th>
                <th>Rejected</th>
                <th>Rejection Quantity </th>
                <th>Date</th> 
                <th>  </th>
            </tr>
        </thead>
        <tbody>
      
            <c:forEach items="${rawMaterials}" var="rawMaterial" >
            	
              <tr>
              		<td> <input type="hidden" name="id" value="<c:out value="${rawMaterial.id}" />" /> </td>	
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
                    <td><input type="text" name="outward" /> </td>
                    <td><input type="datetime-local" name="rejectedDate"/></td>
                    
                </tr>
              
            </c:forEach>
            
      
                   </tbody>
    </table>
    <input type="submit" value="update"/>
 </form>
</body>
</html>