package me.goldapple.java8to11;

import java.util.function.Function;

//첫번째 파라미터가 입력값의 타입 두번째가 리턴값의 타입.
public class Plus10 implements Function<Integer,Integer>{

    @Override
    public Integer apply(Integer integer){
        return integer+10;
    }

}
