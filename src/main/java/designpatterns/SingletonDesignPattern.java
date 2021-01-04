package designpatterns;

public class SingletonDesignPattern {

    private static SingletonDesignPattern instance = new SingletonDesignPattern();

    private SingletonDesignPattern(){

    }

    public static SingletonDesignPattern getInstance(){
        return instance;
    }

}
