package designpatterns;

public class PizzaFactory {

    public static PizzaStore getPizzaStore(String s){
        PizzaStore pizzaStore= null;
        //https://toashishagarwal.medium.com/remove-that-if-else-ladder-e918ed9dcba
        // replace if else like in above link
        if(s.equals("Dominos")){
            pizzaStore = new DominosPizza();
        }else if(s.equals("PizzaHurt")){
            pizzaStore = new PizzaHurtPizza();
        }
        return pizzaStore;
    }
}
