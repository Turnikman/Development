package semaphores;

import java.util.concurrent.Semaphore;

public class Worker extends Thread {

    private Semaphore semaphore;
    private String workerName;
    private boolean isAdder;

    public Worker(Semaphore semaphore, String workerName, boolean isAdder) {
        this.semaphore = semaphore;
        this.workerName = workerName;
        this.isAdder = isAdder;
    }

    @Override
    public void run() {
        System.out.println(workerName + "начал работать...");
        try {
            System.out.println(workerName + "ждет корзину...");
            semaphore.acquire();
            System.out.println(workerName + "получил доступ к корзине...");
            for (int i = 0; i < 5; i++) {
                if (isAdder) {
                    Cart.reduceWeight();
                } else {
                    Cart.addWeight();
                }
                System.out.println(workerName + "измененный в" + Cart.getWeight());
                Thread.sleep(10L);
            }
            semaphore.release();
            System.out.println(workerName + "по окончании работы с тележкой...");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

}
