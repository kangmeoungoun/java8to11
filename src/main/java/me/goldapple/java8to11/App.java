package me.goldapple.java8to11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App{
    public static void main(String[] args){
        //Static 메소드 레퍼런스
        //Instance 메소드 레퍼런스
        //Constructor 메소드 레퍼런스
        Greeting greeting = new Greeting();
        UnaryOperator<String> hi = Greeting :: hi;
        UnaryOperator<String> hello = greeting :: hello;

        Supplier<Greeting> supplier = Greeting :: new;
        //서로 다른 생성자를 참조한다 new 클릭!
        Function<String,Greeting> function = Greeting::new;
        Greeting greeting1 = function.apply("name");
        System.out.println(greeting1.getName());

        String[] names = {"kmo","goldapple","tel"};
        Arrays.sort(names , (o1 , o2) -> o1.compareToIgnoreCase(o2));

        Arrays.sort(names,String::compareToIgnoreCase);

        System.out.println(Arrays.toString(names));
    }
}
