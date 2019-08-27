package EX2;
/*
 * Classe que lê um arquivo txt linha por linha e imprime a linha em um intervalo regular de tempo
 *
 * @author Danilo Sambugaro created on 26/08/2019 inside the package - EX2
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FileReaderByLine implements Runnable {

    private int timeInterval = 10;

    FileReaderByLine() {
    }

    FileReaderByLine(int timeInterval) {
        this.timeInterval = timeInterval;

    }

    @Override
    public void run() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/main/resources/quotes.txt")); // Cria um novo scanner do arquivo alvo
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine()); // Imprime a linha lida
                Thread.sleep(timeInterval * 1000); // Aguarda timeInteval segundos
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("Interrompendo Thread " + Thread.currentThread().getName());
            if (scanner != null) {
                scanner.close();
            }

        }
    }
}
