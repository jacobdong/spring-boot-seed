package site.igeek.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jacobdong on 16/6/14.
 */
@Component
@EnableScheduling
public class TimedTask {

    private Logger LOG = LoggerFactory.getLogger(TimedTask.class);
    private final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedRate = 1000)
    public void secondTask() {
        LOG.info("每秒执行一次的task-->" + SDF.format(new Date()));

    }

    //    一个cron表达式有至少6个（也可能7个）有空格分隔的时间元素按顺序依次为
    //    1.秒（0~59）
    //    2.分钟（0~59）
    //    3.小时（0~23）
    //    4.天（月）（0~31，但是你需要考虑你月的天数）
    //    5.月（0~11）
    //    6.天（星期）（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）
    //    7.年份（1970－2099）
    //    参考文档: http://rainbowdesert.iteye.com/blog/2107220

    @Scheduled(cron = "59 * * * * *")
    public void minuteTask() {
        LOG.info("每分钟执行一次的task-->" + SDF.format(new Date()));
    }
}
