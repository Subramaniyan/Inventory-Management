package controller;

import java.io.IOException;  
import java.io.PrintWriter;  

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

import model.RawMaterials;
import dao.MasterDao;

public class MasterRawServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 
	private MasterDao dao;
	private static String SUCCESS = "Success.jsp";
	private static String RAW_MATERIAL_INSERT = "RawMaterialInsert.jsp";
	
	public MasterRawServlet() {
		super();
		dao = new MasterDao();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {  
		
		response.setContentType("text/html");    
        PrintWriter out = response.getWriter(); 
        RawMaterials rawMaterials = new RawMaterials();
        
        rawMaterials.setName(request.getParameter("name"));
        rawMaterials.setUnit(request.getParameter("unit"));
        rawMaterials.setCategory(request.getParameter("category"));
        
        if(dao.insertRawMaterial(rawMaterials)){    
            RequestDispatcher rd=request.getRequestDispatcher(SUCCESS);    
            rd.include(request,response);    
        }    
        else{    
            out.print("<p style=\"color:red\">Couldnt insert the data !! Please try again</p>");    
            RequestDispatcher rd=request.getRequestDispatcher(RAW_MATERIAL_INSERT);    
            rd.include(request,response);    
        } 
	}
   

}
