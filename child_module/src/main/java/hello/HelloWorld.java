package hello;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorld extends Thread {
    private boolean isActive = true;
    static final Logger rootLogger = LogManager.getLogger(HelloWorld.class);

    public void run() {
        while (isActive) {
            try {
                Thread.sleep(1000);
                rootLogger.info("Hello World!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void stopActive() {
        this.isActive = false;
    }
}