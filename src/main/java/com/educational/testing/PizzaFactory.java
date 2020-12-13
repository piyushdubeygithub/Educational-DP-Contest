package com.educational.testing;

public class PizzaFactory {

    public static PizzaStore getPizzaStore(String s){
        PizzaStore pizzaStore= null;
        if(s.equals("Dominos")){
            pizzaStore = new DominosPizza();
        }else if(s.equals("PizzaHurt")){
            pizzaStore = new PizzaHurtPizza();
        }
        return pizzaStore;
    }
}
