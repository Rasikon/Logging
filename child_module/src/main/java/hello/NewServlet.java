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
            out.print("Hello " + ck[0].getValue());

            out.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}