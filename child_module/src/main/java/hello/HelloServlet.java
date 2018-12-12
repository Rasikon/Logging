package hello;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/HelloWorldServlet", loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
    private HelloWorld hello = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        hello = new HelloWorld();
        hello.start();
    }

    @Override
    public void destroy() {
        if (hello != null) {
            hello.stopActive();
        }
    }
}


