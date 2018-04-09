package net.sjl.logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;

import net.sjl.logger.bean.Worker;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerApplicationTests {

  @Autowired
  private Worker worker; 

  @Test
  public void shouldApplyCustomAnnotation() throws InterruptedException {
    worker.serve();
  }
}
