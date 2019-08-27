package EX2;

/*
 * Exercicio 2
 * Faça uma thread Java que realize a leitura de um arquivo texto com frases e exiba as frases a cada 10 segundos.
 *
 * @author Danilo Sambugaro created on 20/08/2019 inside the package - EX2
 */

public class MainExercicio2 implements Runnable {

    public static void main(String[] args) {
        MainExercicio2 mainExercicio2 = new MainExercicio2();
        mainExercicio2.startExercise();

    }

    public void startExercise() {
        // Cria uma instancia da classe responsável por ler um arquivo linha por linha
        FileReaderByLine fileReaderByLine = new FileReaderByLine();

        // Cria uma thread para executar a leitura do arquivo
        Thread readFileByLine = new Thread(fileReaderByLine, "fileReaderByLine");
        readFileByLine.start(); // Inicia a thread

        try {
            readFileByLine.join();
        } catch (InterruptedException e) {
            readFileByLine.interrupt();
            System.out.println("Interrompendo Thread " + Thread.currentThread().getName());
        }
    }


    @Override
    public void run() {
        this.startExercise();
    }
}



