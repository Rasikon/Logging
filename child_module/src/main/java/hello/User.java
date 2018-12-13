package hello;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class User extends Thread {
    private boolean isActive = true;
    private String nam = null;
    static final Logger rootLogger = LogManager.getLogger(User.class);

    public void run() {
        this.isActive = true;
        while (isActive) {
            try {
                if (nam != null)
                    rootLogger.info("Hello " + nam);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void stopActive() {
        this.isActive = false;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }
}