package me.goldapple.java8to11;

public interface Foo{
    void printName();



    /*  사용시 주의사항 : 이인터페이스 구현한 구현체들에 따라 값이 다르다 getName()에 무슨 값을 올지 모른다 null이 올수도 있고
     *  이런걸 방지하기 위해 문서화를 잘해야 한다. 내가 제공하는 기본구현체가 어떠한 일을 하는거다 적어줘야 한다.
     *  @implSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     *
     **/
    default void printNmameUpperCase(){
        System.out.println(getName().toUpperCase());
    }

    static void printAnything(){
        System.out.println("Foo");
    }
    String getName();
}
