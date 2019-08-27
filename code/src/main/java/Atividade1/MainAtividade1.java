package Atividade1;

import EX1.MainExercicio1;
import EX2.MainExercicio2;
import EX3.MainExercicio3;
import EX4.MainExercicio4;
import EX5.MainExercicio5;


/*
* Classe principal com todos os exercicios da Atividade
*
* Atividade 1 - Programação Concorrente
* 1. Faça um programa em Java que inicie três threads e, cada thread, espere um tempo aleatório para terminar.
* 2. Faça uma thread Java que realize a leitura de um arquivo texto com frases e exiba as frases a cada 10 segundos.
* 3. Faça um programa Java que envia interrupções para as threads dos exercı́cios anteriores. As threads devem fazer o tratamento dessas interrupções e realizar uma finalização limpa.
* 4. Faça uma Thread que monitora um conjunto de threads e exiba quais threads receberam sinais de interrupção.
* 5. Faça uma thread Java que fica aguardando uma sequência numérica de tamanho arbitrário digitado por usuário para realizar uma soma. Use o join().
*
* @author Danilo Sambugaro created on 20/08/2019 inside the package - Atividade1
*/

public class MainAtividade1 {
    private MainExercicio1 exercicio1;
    private MainExercicio2 exercicio2;
    private MainExercicio3 exercicio3;
    private MainExercicio4 exercicio4;
    private MainExercicio5 exercicio5;

    MainAtividade1(){
        // Criação das instancias dos exercicios
        exercicio1 = new MainExercicio1();
        exercicio2 = new MainExercicio2();
        exercicio3 = new MainExercicio3();
        exercicio4 = new MainExercicio4();
        exercicio5 = new MainExercicio5();
    }

    public static void main(String[] args) {
        MainAtividade1 atividade1 = new MainAtividade1();

        System.out.println("* * * * * Execução do exercicio 1 * * * * *");
        // Execução do exercicio 1
        Thread exercicio1 = new Thread(atividade1.exercicio1, "Exercicio 1");
        exercicio1.start();
        try {
            exercicio1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("* * * * * Execução do exercicio 2 * * * * *");
        // Execução do exercicio 2
        Thread exercicio2 = new Thread(atividade1.exercicio2, "Exercicio 2");
        exercicio2.start();
        try {
            exercicio2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("* * * * * Execução do exercicio 3 * * * * *");
        // Execução do exercicio 3
        Thread exercicio3 = new Thread(atividade1.exercicio3, "Exercicio 3");
        exercicio3.start();
        try {
            exercicio3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("* * * * * Execução do exercicio 4 * * * * *");
        // Execução do exercicio 4
        Thread exercicio4 = new Thread(atividade1.exercicio4, "Exercicio 4");
        exercicio4.start();
        try {
            exercicio4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("* * * * * Execução do exercicio 5 * * * * *");
        // Execução do exercicio 5
        Thread exercicio5 = new Thread(atividade1.exercicio5, "Exercicio 5");
        exercicio5.start();
        try {
            exercicio5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
