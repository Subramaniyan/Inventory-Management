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

import model.Wip;
import dao.WipDao;

public class WipServlet  extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 
	private WipDao dao;
	private static String SUCCESS = "Success.jsp";
	private static String WIP = "Wip.jsp";
	
	public WipServlet() {
		super();
		dao = new WipDao();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {  
		
		response.setContentType("text/html");    
        PrintWriter out = response.getWriter(); 
        Wip wip = new Wip();
        
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
        
        wip.setName(request.getParameter("name"));
        wip.setQuantity(request.getParameter("quantity"));
        wip.setDate1(sql);

        if(dao.insertWip(wip)) {
        	 RequestDispatcher rd=request.getRequestDispatcher(SUCCESS);    
             rd.forward(request,response);    
         }    
         else{    
             out.print("<p style=\"color:red\">Couldnt insert the data !! Please try again</p>");    
             RequestDispatcher rd=request.getRequestDispatcher(WIP);    
             rd.include(request,response);    
         } 
	}

}
