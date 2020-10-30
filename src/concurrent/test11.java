package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author ys 2020/7/8
 * @description
 */
public class test11 {

  public static void main(String[] args) {
    ThreadPoolExecutor executorService = new ThreadPoolExecutor(3, 3,
        0L, TimeUnit.MILLISECONDS,
        new LinkedBlockingQueue<Runnable>());
    for(int i=0;i<10;i++){
      List<String> aa=new ArrayList<>();
        executorService.execute(()->{

          System.out.println("aaa");
          try {
            TimeUnit.SECONDS.sleep(2);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        });
      }

    executorService.shutdown();

  }
}
