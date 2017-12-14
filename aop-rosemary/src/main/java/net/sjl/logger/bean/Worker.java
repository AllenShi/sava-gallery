package net.sjl.logger.bean;

import org.springframework.stereotype.Component;
import net.sjl.logger.annotation.LogExecutionTime;

@Component
public class Worker {

  @LogExecutionTime
  public void serve() throws InterruptedException {
    Thread.sleep(2000);
  }
}
