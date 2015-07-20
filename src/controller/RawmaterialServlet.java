package controller;

import java.io.IOException;  
import java.io.PrintWriter;  

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

import model.RawMaterials;
import dao.RawmaterialDao; 

public class RawmaterialServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;  
	private RawmaterialDao dao;
	private static String SUCCESS = "Success.jsp";
	private static String RAW_MATERIAL = "RawMaterial.jsp";
	  
    public RawmaterialServlet() {
		super();
		dao = new RawmaterialDao();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {    
  
        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();  
        RawMaterials rawMaterial = new RawMaterials();
           
        rawMaterial.setName(request.getParameter("rawmaterialType"));  
        //rawMaterial.setQuantity(request.getParameter("quantity"));  
        //rawMaterial.setUnit(request.getParameter("unit"));   
        //rawMaterial.setCategory(request.getParameter("category"));   
        rawMaterial.setInward(request.getParameter("inward") ); 
      //  rawMaterial.setOutward(request.getParameter("outward") ); 
        //rawMaterial.setRejection(request.getParameter("rejection") );    
        
        if(dao.insert(rawMaterial)){    
            RequestDispatcher rd=request.getRequestDispatcher(SUCCESS);    
            rd.include(request,response);    
        }    
        else{    
            out.print("<p style=\"color:red\">Couldnt insert the data !! Please try again</p>");    
            RequestDispatcher rd=request.getRequestDispatcher(RAW_MATERIAL);    
            rd.include(request,response);    
        }    
    
    } 

}
