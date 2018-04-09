package net.sjl.logger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import net.sjl.logger.bean.Worker;

@Configuration
@ComponentScan("net.sjl.logger.bean")
public class AOPConfiguration {

  @Bean
  public Worker worker() {
    return new Worker();
  }
}
