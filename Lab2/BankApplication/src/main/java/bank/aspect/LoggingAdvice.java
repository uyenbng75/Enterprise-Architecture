package bank.aspect;

import bank.integration.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Aspect
@Configuration
public class LoggingAdvice {

    @Autowired
    private Logger logger;

    @After("execution (* bank.service.AccountServiceImpl.*(..))")
    public void loggingAfter(JoinPoint joinPoint){
        logger.log("Logging at "+ LocalDateTime.now()+ " in "+ joinPoint.getSignature().getName());
    }
}
