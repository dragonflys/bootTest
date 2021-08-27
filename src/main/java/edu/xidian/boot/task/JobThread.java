package edu.xidian.boot.task;

public class JobThread {
    // 线程阻塞形式实现定时任务
    public static class Demo01 {
        static long count = 0;

        public static void main(String[] args) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(1000);
                            count++;
                            System.out.println(count);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };

            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
