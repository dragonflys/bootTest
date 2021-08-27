package edu.xidian.boot.config;


import edu.xidian.boot.task.QuartzJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    private static final String ID = "quartz_test";

    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(QuartzJob.class)
                .withIdentity(ID + "01")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger(){
        //调度计划的构造器
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5) //频率
                .withRepeatCount(3); // 重复次数

        return TriggerBuilder.newTrigger()
                .forJob(jobDetail())
                .withIdentity(ID + "01Trigger")
                .withSchedule(simpleScheduleBuilder)
                .build();

    }

}
