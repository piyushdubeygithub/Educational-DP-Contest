package designpatterns;

public class LazySingletonDesign {
    private static LazySingletonDesign instance = null;

    private LazySingletonDesign(){

    }

    public static LazySingletonDesign getInstance(){
        if(instance == null){
            synchronized (LazySingletonDesign.class){
                if(instance == null){
                    instance = new LazySingletonDesign();
                }
            }
        }
        return instance;
    }
}
