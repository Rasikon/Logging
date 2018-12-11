package hello;
 
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloServlet extends HttpServlet {

private static Logger logger=LogManager.getLogger(HelloServlet.class);

public void init(ServletConfig config) throws ServletException {
        super.init();
        while(true){
        try{
        Thread.sleep(1000);
        logger.info("Hello World");
        }catch (InterruptedException e) {
        e.printStackTrace();
        }
        }
    }
    }

