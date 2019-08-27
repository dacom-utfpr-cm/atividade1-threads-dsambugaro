package EX4;
/*
 *
 * @author Danilo Sambugaro created on 27/08/2019 inside the package - EX4
 *
 */

public class ThreadWorker implements Runnable {
    @Override
    public void run() {

        while (true) {
            int i = 0;

//            System.out.println("Thread " + Thread.currentThread().getName() + " executando");

            while (i <= 999999999) {
                i++;
            }

            i = 0;
        }

    }
}
