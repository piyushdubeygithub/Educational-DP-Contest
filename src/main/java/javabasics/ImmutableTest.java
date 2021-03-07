package javabasics;

public class ImmutableTest {
    public static void main(String[] args) {
        Age age = new Age(1972, 1, 1);
        ImmutableStudent immutableStudent = new ImmutableStudent(1, "Piyush", age);
        System.out.println(immutableStudent.toString());
        immutableStudent.getAge().setYear(1982);
        System.out.println(immutableStudent.toString());

    }
}
