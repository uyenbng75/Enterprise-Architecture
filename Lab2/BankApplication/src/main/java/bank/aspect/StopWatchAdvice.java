package bank.aspect;

import bank.integration.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import java.time.LocalDateTime;

@Configuration
@Aspect
public class StopWatchAdvice {
    @Autowired
    private Logger logger;

    @Around("execution(* bank.service.*.*(..))")
    public Object Timer (ProceedingJoinPoint call) throws Throwable {
        StopWatch clock = new StopWatch("Duration: ");
        clock.start(call.toShortString());

        Object obj = call.proceed();
        clock.stop();
        System.out.println(clock.prettyPrint());

        return obj;
    }
}
