package hello;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/HelloNewServlet")
public class NewServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            Cookie ck[] = req.getCookies();
			for(Cookie cookie: ck){
				if(cookie.getName().equals("ckname"))
                   out.print("Hello " + cookie.getValue());
			}
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}