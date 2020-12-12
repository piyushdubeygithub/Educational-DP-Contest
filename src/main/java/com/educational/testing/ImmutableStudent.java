package com.educational.testing;

 public  final class ImmutableStudent {
     final private int id;
     final private String name;
     final private Age age;

    public ImmutableStudent(int id, String name, Age age) {
        this.id = id;
        this.name = name;
        this.age = new Age(age.getYear(), age.getMonth(), age.getDay());
    }

    public int getId() {
        return id;
    }

     @Override
     public String toString() {
         return "ImmutableStudent{" +
                 "id=" + id +
                 ", name='" + name + '\'' +
                 ", age=" + age +
                 '}';
     }

     public String getName() {
        return name;
    }

     public Age getAge() {
         return new Age(age.getYear(),age.getMonth(),age.getDay());
     }
 }
