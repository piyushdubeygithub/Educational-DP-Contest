package javabasics;

import java.util.Arrays;
import java.util.List;

public class Stream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
//        numbers.stream()
//                .filter(e->e%2==0);
        System.out.println(numbers.stream()
        .filter(e->e%2==0).count());
        numbers.forEach(System.out::println);

    }
}
