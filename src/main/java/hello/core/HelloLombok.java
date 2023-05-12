package hello.core;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
// 롬복 사용 시 getter setter 사용 시 자동으로 생성해줌 setName, setAge
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("aaa");

        System.out.println("helloLombok = " + helloLombok);
    }

}
