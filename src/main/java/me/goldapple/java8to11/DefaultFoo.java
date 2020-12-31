package me.goldapple.java8to11;




public class DefaultFoo implements Foo{

    String name;

    public DefaultFoo(String name){
        this.name = name;
    }

    //재정의 하는것도 가능하다.
//    @Override
//    public void printNmameUpperCase(){
//
//    }

    @Override
    public void printName(){
        System.out.println(this.name);
    }


    @Override
    public String getName(){
        return this.name;
    }

}
