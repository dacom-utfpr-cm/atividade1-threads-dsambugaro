package EX3;


/*
 * Exercicio 3
 * Faça um programa Java que envia interrupções para as threads dos exercı́cios anteriores. As threads devem fazer o tratamento dessas interrupções e realizar uma finalização limpa.
 *
 * @author Danilo Sambugaro created on 20/08/2019 inside the package - EX3
 */

import EX1.MainExercicio1;
import EX2.MainExercicio2;

public class MainExercicio3 implements Runnable {

    private MainExercicio1 exercicio1;
    private MainExercicio2 exercicio2;
    private Thread exercicio1Thread;
    private Thread exercicio2Thread;

    public MainExercicio3() {
        this.exercicio1 = new MainExercicio1();
        this.exercicio2 = new MainExercicio2();
        this.exercicio1Thread = new Thread(this.exercicio1, "Exercicio 1");
        this.exercicio2Thread = new Thread(this.exercicio2, "Exercicio 2");
    }

    public static void main(String[] args) {
        MainExercicio3 mainExercicio3 = new MainExercicio3();
        try {
            mainExercicio3.startExercise();
        } catch (InterruptedException e) {
            System.out.println("Interrompendo Thread " + Thread.currentThread().getName());
            if (!mainExercicio3.exercicio1Thread.isInterrupted()){
                mainExercicio3.exercicio1Thread.interrupt();
            }
            if (!mainExercicio3.exercicio2Thread.isInterrupted()){
                mainExercicio3.exercicio2Thread.interrupt();
            }
        }
    }

    public void startExercise() throws InterruptedException {

        System.out.println("Iniciando exercicio 1");

        // Execução do exercicio 1
        exercicio1Thread.start();
        System.out.println("Iniciando exercicio 2");
        // Execução do exercicio 2
        exercicio2Thread.start();


        Thread.sleep(5000);
        if (!exercicio1Thread.isInterrupted()) {
            exercicio1Thread.interrupt();
        }

        exercicio1Thread.join();
        System.out.println("Exercicio 1 interrompido");

        Thread.sleep(5000);
        if (!exercicio2Thread.isInterrupted()) {
            exercicio2Thread.interrupt();
        }

        exercicio2Thread.join();
        System.out.println("Exercicio 2 interrompido");

    }

    public Thread getExercicio2Thread() {
        return exercicio2Thread;
    }

    public Thread getExercicio1Thread() {
        return exercicio1Thread;
    }


    @Override
    public void run() {
        try {
            this.startExercise();
        } catch (InterruptedException e) {
            System.out.println("Interrompendo Thread " + Thread.currentThread().getName());
            if (!exercicio1Thread.isInterrupted()){
                exercicio1Thread.interrupt();
            }
            if (!exercicio2Thread.isInterrupted()){
                exercicio2Thread.interrupt();
            }
        }
    }
}
