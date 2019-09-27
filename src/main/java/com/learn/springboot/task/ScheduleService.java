package com.learn.springboot.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.zone.ZoneRules;

/**
 * @author: zhenghailong
 * @date: 2019/9/27 23:17
 * @modified By:
 * @description:
 */
@Service
public class ScheduleService {
    /**
     * 每隔一秒执行一次
     * @Async：使用异步执行
     */
    @Scheduled(fixedRate = 1000)
    @Async
    public void job1(){
        System.out.println("定时任务执行了");
    }

    /**
     *cron:使用表达式的方式定义任务执行时间
     * zone:指定时区
     * fixedDelay:表示从上一个任务完成开始到下一个任务开始的间隔，单位毫秒
     * fixedDelayString:与fixedDelay相同，只是使用字符串，这样可以使用SpEL表达式来引入配置文件的配置
     * initialDelay:在spring ioc完成初始化后，首次任务执行延迟时间，单位为毫秒
     * initialDelayString:与initialDelay相同，只是使用字符串，这样可以使用SpEL来引入配置文件的配置
     * fixedRate:从上一个任务开始到下一个任务开始的间隔，单位为毫秒
     * fixedRateString:与fixedRate相同，只是使用字符串，这样可以使用SpEL来引入配置文件的配置
     *
     * cron:有6-7个空格分隔的时间元素，按顺序依次是“秒 分 时 天 月 星期 年”其中年可以不配置
     * 如：0 0 0 ？ * WED,表示每个星期3的0点整执行
     * ？表示不指定值，用于处理天和星期配置的冲突
     * *号表示任意值
     * - 指定时间区间
     * / 指定时间间隔执行
     * L 最后的
     * # 第几个
     * ，列举多个项
     */
    /*@Scheduled(cron = "",zone = "",fixedDelay = 1000,fixedDelayString = "1000",
                initialDelay = 1000,initialDelayString = "1000",fixedRate = 1000,fixedRateString = "1000")*/
    public void job2(){
        System.out.println("job2");
    }
}
