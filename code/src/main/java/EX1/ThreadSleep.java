package EX1;

import java.util.Random;


/*
* Classe que representa uma Thread simples que "dorme" por um tempo aleatório entre 5 e 30 segundos e finaliza
*
* @author Danilo Sambugaro created on 20/08/2019 inside the package - EX1
*/

class ThreadSleep implements Runnable{

    private int sleepTime;

    ThreadSleep(){
        // Gera um número aleatório entre 5000 e 30000
        Random r = new  Random();
        this.sleepTime = r.nextInt((30000 - 5000) + 1) + 5000;
    }

    @Override
    public void run() {

        try {
            System.out.println("Sou a Thread " + Thread.currentThread().getName() + " e vou dormir por " + (this.sleepTime/1000) + " segundos..." );
            Thread.sleep(this.sleepTime);
            System.out.println("Sou a Thread " + Thread.currentThread().getName() + ", acordei e vou finalizar minha execução.");
        } catch (InterruptedException e) {
            System.out.println("Interrompendo Thread " + Thread.currentThread().getName());
        }

    }
}
