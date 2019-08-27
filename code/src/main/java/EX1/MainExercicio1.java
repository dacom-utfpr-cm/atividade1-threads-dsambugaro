package EX1;



/*
 * Exercicio 2
 * Faça uma thread Java que realize a leitura de um arquivo texto com frases e exiba as frases a cada 10 segundos.
 *
 * @author Danilo Sambugaro created on 20/08/2019 inside the package - EX1
 */


public class MainExercicio1 implements Runnable{

    public static void main(String[] args) {
        MainExercicio1 mainExercicio1 = new MainExercicio1();
        mainExercicio1.startExercise();
    }

    public void startExercise() {
        // Criação das instancias das Threads
        ThreadSleep threadSleep1 = new ThreadSleep();
        ThreadSleep threadSleep2 = new ThreadSleep();
        ThreadSleep threadSleep3 = new ThreadSleep();

        // Inicia a execução das Threads

        Thread sleeping1 = new Thread(threadSleep1, "threadSleep1");
        sleeping1.start();
        Thread sleeping2 = new Thread(threadSleep2, "threadSleep2");
        sleeping2.start();
        Thread sleeping3 = new Thread(threadSleep3, "threadSleep3");
        sleeping3.start();


        try {
            sleeping1.join();
            sleeping2.join();
            sleeping3.join();
        } catch (InterruptedException e) {

            sleeping1.interrupt();
            sleeping2.interrupt();
            sleeping3.interrupt();
            System.out.println("Interrompendo Thread " + Thread.currentThread().getName());

        }

    }

    @Override
    public void run() {
        this.startExercise();
    }
}
