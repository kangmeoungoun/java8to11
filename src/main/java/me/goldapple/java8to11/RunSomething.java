package me.goldapple.java8to11;

@FunctionalInterface
public interface RunSomething{
    int  doIt(int number);
    static void printName(){
        System.out.println("keesun");
    }
    default void printAge(){
        System.out.println("40");
    }
}