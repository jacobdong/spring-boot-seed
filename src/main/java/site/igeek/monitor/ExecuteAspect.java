package site.igeek.monitor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by jacobdong on 16/6/13.
 */

@Aspect
@Component
public class ExecuteAspect {
    private final Logger LOG = LoggerFactory.getLogger(ExecuteAspect.class);

    @Pointcut("@annotation(site.igeek.monitor.Execute)")
    public void annotationPointCut() {

    }

//    @Before("annotationPointCut()")
//    public void before(JoinPoint joinPoint) {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//
//        Method method = signature.getMethod();
//        Execute execute = method.getAnnotation(Execute.class);
//
//        LOG.info("=============================================");
//    }

    //环绕通知
    @Around("annotationPointCut()")
    public Object addTest(ProceedingJoinPoint proceedingJoinPoint) throws Exception {
        long begin = System.nanoTime();
        long start = System.currentTimeMillis();
        try {

            Object object = proceedingJoinPoint.proceed();
            LOG.info("参数为" + proceedingJoinPoint.getTarget());
            LOG.info("参数为" + proceedingJoinPoint.getArgs());
            LOG.info("=============================================");
            LOG.info("方法耗时:" + ((System.nanoTime() - begin) / (1000 * 1000)));
            LOG.info("方法耗时:" + (System.currentTimeMillis() - start));
            LOG.info("=============================================");
            return object;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new Exception();
        }

    }
}



