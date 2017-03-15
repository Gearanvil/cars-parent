package pl.jwrabel.javandwro2.cars.watki;

/**
 * Created by RENT on 2017-03-15.
 */
public class TreadingDemo {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            public void run() {

                long start = System.nanoTime();
                String s = "";
                for (int i = 0; i < 50000; i++) {
                    s += "ABC";
                }
                double duration = (System.nanoTime() - start) / 1_000_000_000d;
                System.out.println("Duration " + duration);
            }
        };
        thread.start();

        Thread thread2 = new Thread() {
            public void run() {

                long start = System.nanoTime();
                String s = "";
                for (int i = 0; i < 50000; i++) {
                    s += "ABC";
                }
                double duration = (System.nanoTime() - start) / 1_000_000_000d;
                System.out.println("Duration " + duration);
            }
        };
        thread2.start();


    }

}
