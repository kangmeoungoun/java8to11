package me.goldapple.java8to11;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args){
        List<String> names = new ArrayList<>();
        names.add("kmo");
        names.add("goldapple");
        names.add("toby");
        names.add("foo");

        Stream<String> stringStream = names.stream().map(String :: toUpperCase);
        names.forEach(System.out :: println); //데이터들을 변경하지 않는다.

        //중계형 오퍼레이터는 반드시 종료형 오퍼레이터가 와야 중계형 이 실행된다.없으면 중계형 무의미
        names.stream().map((s)->{
            System.out.println(s);
            return s.toLowerCase();
        });
        System.out.println("=========================");
        List<String> collect = names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out :: println);

        for(String name :names ){
            if(name.startsWith("k")){
                System.out.println(name.toUpperCase());
            }
        }
        //->
        System.out.println("=====================");

        //데이터가 방대하게 많을때 parallelStream 사용 하면 좋다.
        List<String> collect1 = names.parallelStream().map((s -> {
            System.out.println(s + " "+Thread.currentThread().getName());
            return s.toUpperCase();
        })).collect(Collectors.toList());
        collect1.forEach(System.out :: println);

    }
}
