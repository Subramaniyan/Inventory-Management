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
import dao.LoginDao;  
  
public class LoginServlet extends HttpServlet{  
  
    private static final long serialVersionUID = 1L;  
    private LoginDao dao;
    private static String LOGIN = "Login.jsp";
	private static String MAIN = "Main.jsp";
  
    public LoginServlet() {
		super();
		dao = new LoginDao();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {    
  
        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
        User user = new User();
          
        user.setUserName(request.getParameter("username"));    
        user.setPassword(request.getParameter("userpass")); 
        user.setEmail("");
     
          
        HttpSession session = request.getSession(false);  
        if(session!=null)  
        session.setAttribute("name", request.getParameter("username"));  
  
        if(dao.validate(user)){    
            RequestDispatcher rd=request.getRequestDispatcher(MAIN);    
            rd.forward(request,response);    
        }    
        else{    
            out.print("<p style=\"color:red\">Sorry username or password is invalid</p>");    
            RequestDispatcher rd=request.getRequestDispatcher(LOGIN);    
            rd.include(request,response);    
        }    
  
        out.close();    
    }    
}   