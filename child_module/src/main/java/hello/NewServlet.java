package hello;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;

@WebServlet(urlPatterns = "/HelloNewServlet")
public class NewServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp){  
    try{  
  
    resp.setContentType("text/html");  
    PrintWriter out = resp.getWriter();  
      
    Cookie ck[]=req.getCookies();  
    out.print("Hello "+ck[0].getValue());  
  
    out.close();  
  
         }catch(Exception e){System.out.println(e);}  
    }  
}