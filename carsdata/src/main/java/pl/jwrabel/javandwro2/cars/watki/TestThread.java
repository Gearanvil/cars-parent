package pl.jwrabel.javandwro2.cars.watki;

/**
 * Created by RENT on 2017-03-15.
 */
public class TestThread extends Thread {
    @Override
    public void run() {

        long start = System.nanoTime();
        String s = "";
        for (int i = 0; i < 50000; i++) {
            s += "ABC";
        }
        double duration = (System.nanoTime() - start) / 1_000_000_000d;
        System.out.println("Duration " + duration);
    }


    public static void main(String[] args) {
        TestThread thread1 = new TestThread();
        TestThread thread2 = new TestThread();
        TestThread thread3 = new TestThread();
        TestThread thread4 = new TestThread();
        TestThread thread5 = new TestThread();
        TestThread thread6 = new TestThread();
        TestThread thread7 = new TestThread();
        TestThread thread8 = new TestThread();

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();







    }
    }

