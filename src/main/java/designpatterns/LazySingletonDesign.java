package designpatterns;

public class LazySingletonDesign {
    private static LazySingletonDesign instance = null;

    static final Object lock = new Object();

    private LazySingletonDesign(){

    }

    public static LazySingletonDesign getInstance(){
        if(instance == null){
            synchronized (lock){
                if(instance == null){
                    instance = new LazySingletonDesign();
                }
            }
        }
        return instance;
    }
}
