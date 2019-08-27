package EX5;

/*
 * Exercicio 5
 * Faça uma thread Java que fica aguardando uma sequência numérica de tamanho arbitrário digitado pelo
 * usuário para realizar uma soma. Use o join().
 *
 * @author Danilo Sambugaro created on 20/08/2019 inside the package - EX1
 */


import java.util.ArrayList;

public class MainExercicio5 implements Runnable {

    private ArrayList<Integer> inputList = new ArrayList<Integer>();

    public static void main(String[] args) {
        MainExercicio5 mainExercicio5 = new MainExercicio5();
        mainExercicio5.startExercise();
    }

    public void startExercise() {
        ReadInput readInput = new ReadInput(inputList);
        Thread readInputThread = new Thread(readInput, "readInput");
        readInputThread.start();

        try {
            readInputThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Integer sum = 0;
        for(Integer i : inputList)
            sum += i;

        System.out.println("A soma dos números digitados é: " + sum);

    }


    @Override
    public void run() {
        this.startExercise();
    }
}
