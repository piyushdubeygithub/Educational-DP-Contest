package multithreading;

public class PrintEvenOdd {
    static int counter = 1;
    static int n=10;
    public static void main(String[] args) {
        PrintEvenOdd printEvenOdd = new PrintEvenOdd();
       Thread t1 = new Thread(() -> {
           printEvenOdd.printOddNumber();
       });
       Thread t2 = new Thread(() -> {
           printEvenOdd.printEvenNumber();
       });
       t1.setName("thread1");
       t2.setName("thread2");
       t1.start();
       t2.start();
    }

    private  void printOddNumber() {
        synchronized (this){
            while (counter<n){
                if(counter%2==0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+": "+counter);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter++;
                notify();
            }
        }
    }

    private void printEvenNumber() {
        synchronized (this){
            while(counter<n){
                if (counter%2==1){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+": "+counter);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter++;
                notify();
            }
        }
    }
}
