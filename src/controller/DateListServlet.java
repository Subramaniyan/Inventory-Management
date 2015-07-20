package controller;

import java.io.IOException;  
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

import dao.DisplayDao;

public class DateListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 
	private DisplayDao dao;
	private static String LIST = "List.jsp";
	
	public DateListServlet() {
		super();
		dao = new DisplayDao();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {  
		
        String forward="";
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = null;
		try {
			parsed = dateFormat.parse(request.getParameter("date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sql = new java.sql.Date(parsed.getTime());
        
        request.setAttribute("rawMaterials", dao.getAllRawmaterial(sql));  
        forward = LIST;
        RequestDispatcher rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);
	}
}
