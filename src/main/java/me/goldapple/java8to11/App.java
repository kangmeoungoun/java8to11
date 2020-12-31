package me.goldapple.java8to11;



public class App {
    public static void main(String[] args){
      Foo foo = new DefaultFoo("goldapple");
        foo.printName();
        foo.printNmameUpperCase();
        Foo.printAnything();
        System.out.println(foo.toString());
    }
}
