package concurrent;

public class Produceer implements Runnable{

    private producerOrConsume producerOrConsume;
    public Produceer(producerOrConsume producerOrConsume){
        this.producerOrConsume=producerOrConsume;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                producerOrConsume.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
