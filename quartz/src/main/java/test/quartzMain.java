package test;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author cj34920
 * Date: 2018/07/18
 */
public class quartzMain {
    public static void main(String[] args) {
        //定义一个JobDetail
        JobDetail jobDetail = JobBuilder.newJob(HelloQuartz.class)
                //定义name和group
                .withIdentity("job1", "group1")
                //job需要传递的内容
                .usingJobData("name", "sdas")
                .build();
        //定义一个Trigger
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                //加入 scheduler之后立刻执行
                .startNow()
                //定时 ，每个1秒钟执行一次
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1)
                        //重复执行
                        .repeatForever()).build();
        try {
            //创建scheduler
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start(); //运行一段时间后关闭
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            scheduler.shutdown();
        } catch (
                SchedulerException e) {
            e.printStackTrace();
        }
    }
}