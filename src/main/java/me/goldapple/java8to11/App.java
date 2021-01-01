package me.goldapple.java8to11;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class App {
    public static void main(String[] args){
        List<String> name = new ArrayList<>();
        name.add("kmo");
        name.add("goldapple");
        name.add("toby");
        name.add("foo");
        //name.forEach(System.out :: println);
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while(spliterator.tryAdvance(System.out :: println));
        System.out.println("=====================");
        while(spliterator1.tryAdvance(System.out :: println));
        System.out.println("=====================");
        //name.removeIf(s->s.startsWith("k"));
        name.forEach(System.out :: println);
        System.out.println("=====================");
        Comparator<String> compareToIgnoreCase = String :: compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed().thenComparing(String::compareToIgnoreCase)); //이정렬 하고 다른것또 정렬하고 싶을떄

    }
}
