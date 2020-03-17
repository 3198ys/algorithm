package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestCallableExcetuores {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<String> a=new ArrayList<>();
        for(int i=0;i<3;i++){
            Future<String> submit = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "hello";
                }
            });
            if(!submit.isDone()){
                try {
                    System.out.println(submit.get());
                    a.add(submit.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        executorService.shutdown();

        System.out.println(a.toString());
    }
}
