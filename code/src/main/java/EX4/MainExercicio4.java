package EX4;


/*
 * Exercicio 4
 * Faça uma Thread que monitora um conjunto de threads e exiba quais threads receberam sinais de interrupção.
 *
 * @author Danilo Sambugaro created on 20/08/2019 inside the package - EX1
 */


import EX3.MainExercicio3;

import java.util.concurrent.CopyOnWriteArraySet;

public class MainExercicio4 implements Runnable {

    private CopyOnWriteArraySet<Thread> watchedThreads = new CopyOnWriteArraySet<Thread>();
    private Thread exercicio3Thread;
    private Thread exercicio1Thread;
    private Thread exercicio2Thread;


    public MainExercicio4() {
        MainExercicio3 exercicio3 = new MainExercicio3();
        exercicio3Thread = new Thread(exercicio3, "Exercicio 3");
        exercicio3Thread.start();

        while (exercicio1Thread == null) {
            exercicio1Thread = exercicio3.getExercicio1Thread();
        }

        while (exercicio2Thread == null) {
            exercicio2Thread = exercicio3.getExercicio2Thread();
        }

        watchedThreads.add(exercicio1Thread);
        watchedThreads.add(exercicio2Thread);

    }

    public static void main(String[] args) {
        MainExercicio4 mainExercicio4 = new MainExercicio4();
        mainExercicio4.startExercise();
    }

    public void startExercise() {

        System.out.println("Monitorando Threads...");

        while (!watchedThreads.isEmpty()) {

            for (Thread thread : watchedThreads) {
                if (thread.isInterrupted()) {
                    System.out.println("Thread " + thread.getName() + " interrompida");
                    watchedThreads.remove(thread);

                } else if (thread.isAlive()) {
                    System.out.println("Thread " + thread.getName() + " rodando...");
                } else if (!thread.isAlive()) {
                    System.out.println("Thread " + thread.getName() + " já finalizada");
                    watchedThreads.remove(thread);
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Sem mais Threads para monitorar, encerrando");

    }


    @Override
    public void run() {
        this.startExercise();
    }
}
