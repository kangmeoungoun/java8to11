package me.goldapple.java8to11;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args){
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1,"spring boot",true));
        springClasses.add(new OnlineClass(5,"rest api development",false));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();
        optional.ifPresent(oc->{
            System.out.println(oc.getTitle());
        });

        //있을때도 만들고 없을때도 만든다. orElse createNewClasses()이코드는 무조건 실행된다.
        //OnlineClass onlineClass = optional.orElse(createNewClasses());
        //있을때는 안만들고 없을때는 만든다.
        /*orElse 이미 만들어진 상수 들을 가지고 올때 사용하면 유용하고  orElseGet 동적인걸 만들떄 사용*/
        //OnlineClass onlineClass = optional.orElseGet(App :: createNewClasses);
        //대체할 대안이 없을떄
        //OnlineClass onlineClass = optional.orElseThrow(IllegalStateException::new);

        //다시 필터 사용 해서 옵셔널 리던 받환
        //Optional<OnlineClass> onlineClass = optional.filter(OnlineClass::isClosed);

        //Optional<Optional<Progress>> progress = optional.map(OnlineClass :: getProgress);
        //Optional<Progress> progress1 = progress.orElseThrow();
        //progress1.orElseThrow();
        Optional<Progress> progress1 = optional.flatMap(OnlineClass :: getProgress);
        // ||
        // ||
        Optional<Optional<Progress>> progress2 = optional.map(OnlineClass :: getProgress);
        progress2.orElse(Optional.empty());

        //



    }

    private static OnlineClass createNewClasses(){
        System.out.println("creating new online class");
        return new OnlineClass(10 , "New Class" , false);
    }
}
