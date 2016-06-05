package site.igeek.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import site.igeek.ApplicationLauncher;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by jacobdong on 16/6/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationLauncher.class)
public class MQRedisServiceTest {

    private final Logger LOGGER = LoggerFactory.getLogger(MQRedisServiceTest.class);

    @Resource
    MQservice mQservice;

    private final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Test
    public void setTest() {

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String key = "TEST_" + i;
            String formatDate = SDF.format(new Date());
            mQservice.set(key, formatDate, -1);

            String value = mQservice.get(key);
            Assert.assertEquals(formatDate, value);
        }

        LOGGER.info("测试结束,消耗时间为" + (System.currentTimeMillis() - startTime) + "毫秒");
    }

}
