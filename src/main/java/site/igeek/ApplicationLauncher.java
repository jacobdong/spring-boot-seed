package site.igeek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * Created by jacobdong on 16/5/4.
 */
@SpringBootApplication
public class ApplicationLauncher {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(ApplicationLauncher.class, args);
        System.out.println(ctx.getApplicationName());
        System.out.println(ctx.getEnvironment());
        System.out.println(ctx.getStartupDate());

        System.out.println("Beans available in this application:");
        System.out.println("====================================");


        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        System.out.println("====================================");
    }
}