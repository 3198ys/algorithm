package concurrent;

public class pcstart {
    public static void main(String[] args) {
        producerOrConsume producerOrConsume = new producerOrConsume();
        Thread thread = new Thread(new Consumer(producerOrConsume),"consumer-01");
        Thread thread2 = new Thread(new Consumer(producerOrConsume),"consumer-02");
        Thread thread3 = new Thread(new Consumer(producerOrConsume),"consumer-03");
        Thread thread4 = new Thread(new Produceer(producerOrConsume),"Produceer-01");
        Thread thread5 = new Thread(new Produceer(producerOrConsume),"Produceer-02");
        Thread thread6 = new Thread(new Produceer(producerOrConsume),"Produceer-03");

        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}
