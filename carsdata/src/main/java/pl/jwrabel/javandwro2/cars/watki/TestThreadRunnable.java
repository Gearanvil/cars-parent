package pl.jwrabel.javandwro2.cars.watki;

/**
 * Created by RENT on 2017-03-15.
 */
public class TestThreadRunnable implements Runnable{

    public static void main(String[] args) {
        TestThreadRunnable testThreadRunnable = new TestThreadRunnable();
        Thread thread = new Thread(testThreadRunnable);
        thread.start();
    }
    @Override
    public void run() {
        System.out.println("Watek uruchomiony");
    }
}
