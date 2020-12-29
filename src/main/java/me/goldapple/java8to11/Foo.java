package me.goldapple.java8to11;

import java.util.function.*;

public class Foo{
    public static void main(String[] args){
        Foo foo  = new Foo();
        foo.run();
    }
    private void run(){
        final int baseNumber=10;

        //로컬 클래스 익명 클래스 람다 공통점 : baseNumber 참조 가능
        //로컬 클래스 익명 클래스 와 람다의 차이점 :  스콥이 다르다.  람다는 같은 범위로 간주한다.

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber(){
                int baseNumber =11;
                System.out.println(baseNumber);
            }
        }
        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>(){
            @Override
            public void accept(Integer baseNumber){
                System.out.println(baseNumber);
            }
        };

        // 람다
        IntConsumer printInt = (i)->{

            System.out.println(i+baseNumber);
        };
        printInt.accept(10);
    }

}