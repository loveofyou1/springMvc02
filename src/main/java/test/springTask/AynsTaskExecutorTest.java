package test.springTask;

import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 异步任务
 * @author sunlei19
 * @create 2018/9/26
 */
public class AynsTaskExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        Future<String> future = asyncTaskExecutor.submit(new OutThread());
        System.out.println(future.get());
        Thread.sleep(1000 * 1000L);

    }


    static class OutThread implements Callable<String> {

        @Override
        public String call() throws Exception {
            String ret = " i test callable ";
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(2 * 1000L);
                    System.out.println("i sleep 1s.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return ret;
        }
    }
}
