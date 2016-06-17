package site.igeek;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import site.igeek.exception.ControllerError;

import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * Created by jacobdong on 16/5/4.
 */
@SpringBootApplication
public class ApplicationLauncher {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationLauncher.class);

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(ApplicationLauncher.class, args);


        LOG.info("====================================");
        LOG.debug("Beans available in this application:");
        String[] beanNames = ctx.getBeanDefinitionNames();

        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            LOG.info(beanName);
        }

        LOG.info("当前环境:" + Arrays.toString(ctx.getEnvironment().getActiveProfiles()));
        LOG.info("应用名称:" + (ctx.getApplicationName()));
        LOG.info("启动时间:" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ctx.getStartupDate())));
        LOG.info("全局错误码====================================");

        for (ControllerError error : ControllerError.values()) {
            LOG.info(error.name() + "," + error.getErrorMessage() + "," + error.getErrorCode());
        }
        LOG.info("====================================");
    }
}