package test.springTask;

import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

/**
 * 异步任务验证
 * @author sunlei19
 * @create 2018/9/26
 */
public class AsyncTaskExecutorTest {

    public static void main(String[] args) throws InterruptedException {
        AsyncTaskExecutor executor = new SimpleAsyncTaskExecutor("sys.out");
        executor.execute(new OutThread(), 50000L);
        System.out.println("Hello, World!");
        Thread.sleep(10000 * 1000L);
    }


    static class OutThread implements Runnable {

        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(i + " start ...");
                try {
                    Thread.sleep(2 * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
