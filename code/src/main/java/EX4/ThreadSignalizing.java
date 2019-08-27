package EX4;
/*
 *
 * Classe que implementa uma thread para ficar sinalizando aleatoriamente Threads em uma lista de Threads
 *
 * @author Danilo Sambugaro created on 27/08/2019 inside the package - EX4
 *
 */

import java.util.Random;
import java.util.concurrent.CopyOnWriteArraySet;

public class ThreadSignalizing implements Runnable {

    private CopyOnWriteArraySet<Thread> watchedThreads = null;
    private int maxThreads;

    public ThreadSignalizing(CopyOnWriteArraySet<Thread> watchedThreads){
        this.watchedThreads = watchedThreads;
        this.maxThreads = this.watchedThreads.size();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                Random r = new  Random();

                int i = r.nextInt(maxThreads);
                int j = 0;

                for (Thread thread : watchedThreads) {
                    if (i == j) {
                        thread.interrupt();
                        break;
                    } else {
                        j++;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
