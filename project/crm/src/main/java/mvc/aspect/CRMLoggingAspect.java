package mvc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    /*
    * Wildcard:
    * Match all the return types &&
    * Match all the classes in mvc.controller (.*) &&
    * Match all the methods in mvc.controller (.*.*) &&
    * Match all the parameters (..) of the methods in mvc.controller*/
    @Pointcut("execution(* mvc.controller.*.* (..))")
    private void forControllerPackage(){}
    @Pointcut("execution(* mvc.service.*.* (..))")
    private void forServicePackage(){}
    @Pointcut("execution(* mvc.dao.*.* (..))")
    private void forDAOPackage(){}

    // Combine the Pointcuts
    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow(){}

    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){

        // display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("in @Before: calling method: " + theMethod);

        // display the arguments to the method

        // get the arguments
        Object[] args = theJoinPoint.getArgs();

        // loop through and display args
        for (Object tempArg : args) {
            myLogger.info("arguments: " + tempArg);
        }

    }

    // add @AfterReturning advice
    @AfterReturning(
            pointcut="forAppFlow()",
            returning="theResult"
    )
    public void afterReturning(JoinPoint theJoinPoint, Object theResult){

        // display method we are returning from
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("in @AfterReturning: from method: " + theMethod);

        // display data returned
        myLogger.info("result: " + theResult);
    }
}
