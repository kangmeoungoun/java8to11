package me.goldapple.java8to11;

public class Foo{
    public static void main(String[] args){
        int baseNumber =0;
        RunSomething runSomething = (number) ->{
            //baseNumber++; 밖에 있는 값을 변경할려면 안되고 참조만 할경우는 가능하다.
            //baseNumber final 이라고 가정하고 사용을 해서 이밖에서도 baseNumber 변경 못한다.
            return number + 10 + baseNumber;
        };

        //baseNumber++;
        methodTest(runSomething);
    }
    public static void methodTest(RunSomething runSomething){
        //같은 매개변수를 넣으면 무조건 같은 값이 나와야 그게 함수형 프로그래밍
        //외부에 있는 값을 변경 하려는 경우 도 안됨.

        System.out.println(runSomething.doIt(1));;
        System.out.println(runSomething.doIt(1));;
        System.out.println(runSomething.doIt(1));;
        System.out.println(runSomething.doIt(1));;
    }
}