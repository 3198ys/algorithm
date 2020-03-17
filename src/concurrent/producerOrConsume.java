package concurrent;

import java.util.LinkedList;

/**
 * 生产者消费者 wait()/notify()
 */
public class producerOrConsume {
    private final int MAX_SIZE=10;
    private LinkedList<Object> list=new LinkedList<>();
    public void produce(){
        synchronized (list){
            while (list.size()+1>MAX_SIZE){
                System.out.println("生产者已经满了"+Thread.currentThread().getName());

                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            list.add(new Object());
            System.out.println("生产者"+Thread.currentThread().getName()+"生产了一个产品");
            list.notifyAll();
        }
    }

    public void consume(){
        synchronized (list){
            while (list.size()==0) {
                System.out.println("消费者" + Thread.currentThread().getName() + "仓库已经空了");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                list.remove();
                System.out.println("消费者"+Thread.currentThread().getName()+"消费了一个");
                list.notifyAll();

        }
    }
}
