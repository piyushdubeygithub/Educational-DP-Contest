package com.educational.testing;

import java.util.Scanner;

public class PizzaTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        PizzaStore pizzaStore = PizzaFactory.getPizzaStore(input);
        pizzaStore.getPizza();
    }
}
