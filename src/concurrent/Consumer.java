package concurrent;

public class Consumer implements Runnable{
    private producerOrConsume producerOrConsume;
    public Consumer(producerOrConsume producerOrConsume){
        this.producerOrConsume=producerOrConsume;
    }
    @Override
    public void run() {

        while (true){
            try {
                Thread.sleep(3000);
                producerOrConsume.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
