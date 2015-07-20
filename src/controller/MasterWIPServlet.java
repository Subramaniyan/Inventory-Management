package controller;

import java.io.IOException;  
import java.io.PrintWriter;  

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

import model.Bom;
import model.Process;
import dao.MasterDao;

public class MasterWIPServlet  extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 
	private MasterDao dao;
	private static String SUCCESS = "Success.jsp";
	private static String BOM = "Bom.jsp";
	public MasterWIPServlet() {
		super();
		dao = new MasterDao();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {  
		
		response.setContentType("text/html");    
        PrintWriter out = response.getWriter(); 
        Process process =  new Process();
        Bom bom = new Bom();
        String raw[] = new String[50];
        
        for(int i=1;i<=5;i++) {
        	raw[i] = request.getParameter("drop" + i) + "-" + request.getParameter("raw" + i);
        	 //bom.setRaw1(request.getParameter("drop1") + "-" + request.getParameter("raw1"));
        }
        
        bom.setRaw1(request.getParameter("drop1") + "-" + request.getParameter("raw1"));
        bom.setRaw2(request.getParameter("drop2") + "-" + request.getParameter("raw2"));
        bom.setRaw3(request.getParameter("drop3") + "-" + request.getParameter("raw3"));
        bom.setRaw4(request.getParameter("drop4") + "-" + request.getParameter("raw4"));
        bom.setRaw5(request.getParameter("drop5") + "-" + request.getParameter("raw5"));
        
        if(dao.insertBom(raw)){    
        	
        	int bom_id = dao.selectBom();
        	process.setName(request.getParameter("name"));
        	process.setPartno(request.getParameter("partNo"));
        	process.setUnit(request.getParameter("unit"));
        	process.setCategory(request.getParameter("category"));
        	process.setBomId(bom_id);
        	
        	if(dao.insertProcess(process)) {
        		
        		 RequestDispatcher rd=request.getRequestDispatcher(SUCCESS);    
                 rd.forward(request,response);   
        	} else {
        		out.print("<p style=\"color:red\">Couldnt insert the data !! Please try again</p>");    
                RequestDispatcher rd=request.getRequestDispatcher(BOM);    
                rd.include(request,response);  
        	}
        	
        }
            
        }   
	
	

}
