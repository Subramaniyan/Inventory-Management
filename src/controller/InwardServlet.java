package controller;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

import model.RawMaterials;
import dao.InwardDao; 

public class InwardServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 
	private InwardDao dao;
	private static String SUCCESS = "Success.jsp";
	private static String INWARD = "Inward.jsp";
	
	public InwardServlet() {
		super();
		dao = new InwardDao();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {    
  
        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();  
        RawMaterials rawMaterial = new RawMaterials();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String d = dateFormat.format(date);
        Date parsed = null;;
		try {
			parsed = dateFormat.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
        
        rawMaterial.setName(request.getParameter("rawmaterial"));
        rawMaterial.setVendor(request.getParameter("vendor"));
        rawMaterial.setDate(sql);
        rawMaterial.setInward(request.getParameter("inward"));
        rawMaterial.setMaterialCost(request.getParameter("materialCost"));
        rawMaterial.setExpense(request.getParameter("expenses"));
        rawMaterial.setAccepted(request.getParameter("accepted"));
        rawMaterial.setRejected(request.getParameter("rejected"));
         
        if(dao.insert(rawMaterial)){    
            RequestDispatcher rd=request.getRequestDispatcher(SUCCESS);    
            rd.include(request,response);    
        }    
        else{    
            out.print("<p style=\"color:red\">Couldnt insert the data !! Please try again</p>");    
            RequestDispatcher rd=request.getRequestDispatcher(INWARD);    
            rd.include(request,response);    
        } 
	}
}
