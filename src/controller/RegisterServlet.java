package controller;

import java.io.IOException;  
import java.io.PrintWriter;  

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
  

import model.User;
import dao.RegisterDao;

public class RegisterServlet extends HttpServlet {  
  
    private static final long serialVersionUID = 1L;  
    private RegisterDao dao;
    private static String LOGIN = "Login.jsp";
	private static String MAIN = "Main.jsp";
    
    public RegisterServlet() {
		super();
		dao = new RegisterDao();
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {    
    	
    	response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
        User user = new User();
        
        user.setUserName(request.getParameter("username"));    
        user.setPassword(request.getParameter("userpass")); 
        user.setEmail(request.getParameter("usermail"));
        
        if(!user.getPassword().equals(request.getParameter("confirm-password"))) {
        	out.print("<p style=\"color:red\">Passwords Don't Match</p>");    
            RequestDispatcher rd=request.getRequestDispatcher(LOGIN);    
            rd.include(request,response);  
        }
        
        HttpSession session = request.getSession(false);  
        if(session!=null)  
        session.setAttribute("name", request.getParameter("username")); 
    	
        if(dao.insert(user)){    
            RequestDispatcher rd=request.getRequestDispatcher(MAIN);    
            rd.forward(request,response);    
        } 
        
        out.close(); 
    }
  
        

}
