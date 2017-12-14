package net.sjl.logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import net.sjl.logger.bean.Worker;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LoggerApplication {

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(LoggerApplication.class, args);
    // Worker worker = context.getBean(Worker.class);
    Worker worker = (Worker)context.getBean("worker");
    try {
      worker.serve();
    } catch (Exception e) {}
  }
}
