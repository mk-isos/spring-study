package study.querydsl.dto;

import lombok.Data;

@Data
public class UserDto {
    private String name;
    private int age;

    public UserDto() {
    }

    public UserDto(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
