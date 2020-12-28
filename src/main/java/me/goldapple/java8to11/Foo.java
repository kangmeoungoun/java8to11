package me.goldapple.java8to11;

import java.util.function.*;

public class Foo{
    public static void main(String[] args){
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));;

        //다이렉트로 이런식으로 바로 사용가능
        Function<Integer,Integer> plus11 = (number)->number + 10;
        System.out.println(plus11.apply(1));

        Function<Integer,Integer> multiply2 = (i)->i*2;

        //함수안의 함수 곱하기 2를 먼저하고 그값을 파라미터로 리턴.
        Function<Integer, Integer> compose = plus11.compose(multiply2);
        System.out.println(compose.apply(2));
        //함수안의 함수 더하기 10을 먼저 한후 그값을 파라미터로 리턴.
        Function<Integer, Integer> andthen = plus11.andThen(multiply2);
        System.out.println(andthen.apply(2));

        //입력값 과 리턴값이 같은 경우 하나만 입력받고 사용
        //Function 인자 2개가 같은 타입일때
        UnaryOperator<Integer> plus12 = (i)->i+10;
        System.out.println(plus12.apply(100));

        //입력값을 한개 더 받는다
        BiFunction<Integer,Integer,Integer> test = (a,b)->a+b;
        System.out.println(test.apply(1,2));
        //BiFunction 인자 3개가 같은 타입일떄
        BinaryOperator<Integer> test2 = (a,b)->a+b;
        System.out.println(test2.apply(10,20));;




        //입력값을 받아서 아무값도 리턴하지 않는다.
        Consumer<Integer> printT = (i)-> System.out.println(i);
        printT.accept(10);

        //입력값은 받지 않고 리턴값만 받는다.
        Supplier<Integer> get10 = ()->10;
        System.out.println(get10.get());

        Predicate<String> startsWithGold = (s)->s.startsWith("gold");
        System.out.println(startsWithGold.test("gold"));
        Predicate<Integer> isEven = (i)->  i%2==0;
        System.out.println(isEven.test(10));;




    }

}