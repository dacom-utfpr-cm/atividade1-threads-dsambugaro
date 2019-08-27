package EX4;


/*
 * Exercicio 4
 * Faça uma Thread que monitora um conjunto de threads e exiba quais threads receberam sinais de interrupção.
 *
 * @author Danilo Sambugaro created on 20/08/2019 inside the package - EX4
 */

import java.util.concurrent.CopyOnWriteArraySet;

public class MainExercicio4 implements Runnable {

    private CopyOnWriteArraySet<Thread> watchedThreads = new CopyOnWriteArraySet<Thread>();
    private  int maxThreads;


    public MainExercicio4() {
        this.maxThreads = 4;

        for (int i = 0; i <= maxThreads; i++) {
            // Cria maxThreads instancias de ThreadWorker e inicia a execução
            ThreadWorker workerTemp = new ThreadWorker();
            Thread workerThread = new Thread(workerTemp, "Worker" + i);
            workerThread.start();

            // Adiciona a nova instancia a lista de threads monitoradas
            watchedThreads.add(workerThread);
        }

    }

    public static void main(String[] args) {
        MainExercicio4 mainExercicio4 = new MainExercicio4();
        mainExercicio4.startExercise();
    }

    public void startExercise() {

        // Instanciando e iniciando execução da Thread responsável pela sinalização de interrupção
        ThreadSignalizing signalizing = new ThreadSignalizing(watchedThreads);
        Thread threadSignalizing = new Thread(signalizing, "ThreadSignalizing");
        threadSignalizing.start();

        System.out.println("Monitorando Threads...");

        while (!watchedThreads.isEmpty()) {

            for (Thread thread : watchedThreads) {
                if (thread.isInterrupted()) {
                    System.out.println("Thread " + thread.getName() + " interrompida");
                } else if (!thread.isAlive()) {
                    System.out.println("Thread " + thread.getName() + " finalizada");
                    watchedThreads.remove(thread);
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Sem mais Threads para monitorar");

    }


    @Override
    public void run() {
        this.maxThreads = 4;

        for (int i = 0; i <= maxThreads; i++) {
            // Cria maxThreads instancias de ThreadWorker e inicia a execução
            ThreadWorker workerTemp = new ThreadWorker();
            Thread workerThread = new Thread(workerTemp, "Worker" + i);
            workerThread.start();

            // Adiciona a nova instancia a lista de threads monitoradas
            watchedThreads.add(workerThread);
        }

        this.startExercise();
    }
}
