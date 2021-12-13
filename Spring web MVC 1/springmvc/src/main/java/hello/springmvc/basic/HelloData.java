package hello.springmvc.basic;

import lombok.Data;

@Data //getter setter 자동으로 생성해줌
public class HelloData {
    private String username;
    private int age;
}
