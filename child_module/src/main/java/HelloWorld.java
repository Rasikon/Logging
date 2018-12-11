package hello;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class HelloWorld {
static final Logger rootLogger = LogManager.getRootLogger();
    public static void main(String[] args) {
        rootLogger.error("Hello World!");
    }
}