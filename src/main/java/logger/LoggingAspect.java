package logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.lab2.*.*(..))||execution(* logger.*.*(..))")
    public void runMethod() {}

    @Before("runMethod()")
    public void beforeRun(JoinPoint jp){    System.out.println(jp.getSignature() + " started its work");}

    @AfterReturning("runMethod()")
    public void afterRun(JoinPoint jp){     System.out.println(jp.getSignature() + " ended its work");
    }


}