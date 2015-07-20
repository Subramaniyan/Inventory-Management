package controller;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

import model.RawMaterials;
import dao.RejectionDao; 

public class RejectionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 
	private RejectionDao dao;
	private static String SUCCESS = "Success.jsp";
	private static String LIST_RAW_MATERIAL = "RejectionList.jsp";
	
	public RejectionServlet() {
		super();
		dao = new RejectionDao();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {    
  
        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();  
        
        String[] raw = request.getParameterValues("outward");
        for(int i=0;i<raw.length;i++) {
        	  out.print(raw[i] + "sdfs");
        }
      
        /*RawMaterials rawMaterial = new RawMaterials();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = null;
		try {
			parsed = dateFormat.parse(request.getParameter("date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sql = new java.sql.Date(parsed.getTime());
        
        rawMaterial.setName(request.getParameter("rawmaterial"));
        rawMaterial.setDate(sql);
        rawMaterial.setOutward(request.getParameter("outward"));
        rawMaterial.setId(request.getParameter("id"));
        
        try {
        	parsed = dateFormat.parse(request.getParameter("rejectedDate"));
       }
       catch (ParseException e) {
           e.printStackTrace();
       }
       sql = new java.sql.Date(parsed.getTime());
       
       rawMaterial.setRejectedDate(sql); 
       
       if(dao.insert(rawMaterial)){    
            RequestDispatcher rd=request.getRequestDispatcher(SUCCESS);    
            rd.include(request,response);    
        }    
        else{    
            out.print("<p style=\"color:red\">Couldnt insert the data !! Please try again</p>");    
            RequestDispatcher rd=request.getRequestDispatcher(LIST_RAW_MATERIAL);    
            rd.include(request,response);    
        } */
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		String forward="";
		
		if (action.equalsIgnoreCase("list")){
        request.setAttribute("rawMaterials", dao.getAllRawmaterial());  
        forward = LIST_RAW_MATERIAL;
        RequestDispatcher rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);
		} 
	}
}
