package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


//롬복이 자동으로 생성자 관련된 것들 게터세터를 자동으로 해줘서 쓸 수 있게 해줌 ㄱㅇㄷ~
@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asdfs");

        String name = helloLombok.getName();
        System.out.println("name = " + name);
    }
}
