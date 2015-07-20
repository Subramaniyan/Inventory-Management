package controller;

import java.io.IOException;  
import java.io.PrintWriter;  

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

import model.Units;
import dao.MasterDao;

public class MasterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 
	private MasterDao dao;
	private static String SUCCESS = "Success.jsp";
	private static String UNIT = "Units.jsp";
	
	public MasterServlet() {
		super();
		dao = new MasterDao();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {  
		
		response.setContentType("text/html");    
        PrintWriter out = response.getWriter(); 
        Units unit = new Units();
        
        unit.setName(request.getParameter("unitName"));
        unit.setUnit(request.getParameter("unit"));
        
        if(dao.insertUnit(unit)){    
            RequestDispatcher rd=request.getRequestDispatcher(SUCCESS);    
            rd.forward(request,response);    
        }    
        else{    
            out.print("<p style=\"color:red\">Couldnt insert the data !! Please try again</p>");    
            RequestDispatcher rd=request.getRequestDispatcher(UNIT);    
            rd.include(request,response);    
        } 
	}
   

}
