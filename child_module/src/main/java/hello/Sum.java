package hello;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sum extends Thread {
    static final Logger rootLogger = LogManager.getLogger(Sum.class);

    public void run() {
        rootLogger.info("Thread start" + Thread.currentThread().getName());
        while (HelloServlet.x.intValue() < 10000) {
            HelloServlet.x.incrementAndGet();
            rootLogger.info(Thread.currentThread().getName() + "  " + HelloServlet.x.intValue());
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}	
			
        }
    }


}