package edu.xidian.boot.task;

import java.util.Timer;
import java.util.TimerTask;

public class JobTimeTask {
    static long count = 0;

    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                count++;
                System.out.println(count);
            }
        };
        // 创建timer实例设置间隔时间
        Timer timer = new Timer();
        // 间隔天数
        long delay = 0;
        // 间隔毫秒
        long period = 1000;

        timer.scheduleAtFixedRate(timerTask, delay, period);

    }

}
