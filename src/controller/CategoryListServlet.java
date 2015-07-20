package controller;

import java.io.IOException;  

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

import dao.DisplayDao;

public class CategoryListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 
	private DisplayDao dao;
	private static String LIST = "List.jsp";
	
	public CategoryListServlet() {
		super();
		dao = new DisplayDao();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {  
		
        String forward="";
        
        request.setAttribute("rawMaterials", dao.getAllRawmaterial(request.getParameter("name")));  
        forward = LIST;
        RequestDispatcher rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);
	}
}
