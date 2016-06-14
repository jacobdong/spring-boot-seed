package site.igeek.monitor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
            Class<? extends Object> targetClass = proceedingJoinPoint.getTarget().getClass();
            String className = targetClass.getName();
            String methodName = signature.getName();
            Method method = signature.getMethod();
            LOG.info("=============================================");
            LOG.info("类名为:" + className);
            LOG.info("方法名字为:" + methodName);

            List<String> types = new ArrayList<>();
            List<String> params = new ArrayList<>();

            for (Class clazz : method.getParameterTypes()) {
                types.add(clazz.getName());
            }

            for (String parameterName : signature.getParameterNames()) {
                params.add(parameterName);
            }

            LOG.info("形参类型" + Arrays.toString(types.toArray()));
            LOG.info("形参名称" + Arrays.toString(params.toArray()));
            LOG.info("实参内容" + Arrays.toString(proceedingJoinPoint.getArgs()));
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



