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
        rootLogger.info(x);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("myservlet.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        user.setNam(name);
        doGet(req, resp);
    }

    @Override
    public void destroy() {
        if (hello != null)
            hello.stopActive();
        if (user != null)
            user.stopActive();
    }

}


