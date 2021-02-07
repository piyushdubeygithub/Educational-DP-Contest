package designpatterns;

public class SingletonTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingletonDesign instance1 = LazySingletonDesign.getInstance();
                System.out.println(instance1.hashCode());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(i<=10){
                    LazySingletonDesign instance2 = LazySingletonDesign.getInstance();
                    System.out.println(instance2.hashCode());
                    i++;
                }

            }
        });

        t1.start();
        t2.start();
    }
}
