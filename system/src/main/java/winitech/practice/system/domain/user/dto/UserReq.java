package winitech.practice.system.domain.user.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import winitech.practice.system.domain.user.domain.User;

@Getter
public class UserReq {

    @NotNull
    private String name;
    @NotNull
    private String phone;
    @Positive
    private int age;

    public User toEntity() {
        return User.builder()
                .name(name)
                .phone(phone)
                .age(age)
                .build();
    }
}
