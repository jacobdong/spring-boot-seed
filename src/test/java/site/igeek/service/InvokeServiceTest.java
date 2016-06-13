package site.igeek.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import site.igeek.ApplicationLauncher;

import javax.annotation.Resource;

/**
 * Created by jacobdong on 16/6/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationLauncher.class)
public class InvokeServiceTest {

    @Resource
    InvokeService invokeService;

    @Test
    public void addTest() {
        long begin = System.currentTimeMillis();
        invokeService.add();
        System.out.println("方法耗时:" + (System.currentTimeMillis() - begin));
    }

}
