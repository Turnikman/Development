package semaphores;

import java.util.concurrent.Semaphore;

public class Semaphores {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        new Worker(semaphore, "первый поток ", true).start();
        new Worker(semaphore, "второй поток ", false).start();
    }

}
