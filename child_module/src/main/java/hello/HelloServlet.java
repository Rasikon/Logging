package hello;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(urlPatterns = "/HelloWorldServlet")
public class HelloServlet extends HttpServlet {
    static final Logger rootLogger = LogManager.getLogger(HelloServlet.class);
    private HelloWorld hello = null;
    private User user = null;
    public static AtomicInteger x = new AtomicInteger(0);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        hello = new HelloWorld();
        hello.start();
        user = new User();
        user.start();
		do{
			x=new AtomicInteger(0);
        Sum thread1 = new Sum();
        thread1.start();
        Sum thread2 = new Sum();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		}while(x.intValue()<=10000);
        rootLogger.info(x);
	}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("myservlet.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            String name = req.getParameter("name");
            out.print("Welcome " + name);
            Cookie ck = new Cookie("ckname", name);
            resp.addCookie(ck);
            user.setNam(name);
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void destroy() {
        if (hello != null)
            hello.stopActive();
        if (user != null)
            user.stopActive();
    }

}


