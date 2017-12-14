package net.sjl.logger.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

  @Around("@annotation(net.sjl.logger.annotation.LogExecutionTime)")
  public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();
    Object proceed = joinPoint.proceed();
    long duration = System.currentTimeMillis() - start;
    System.out.println(joinPoint.getSignature() + " executed in " + duration + "ms");
    return proceed;
  }
}