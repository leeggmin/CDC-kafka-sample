package winitech.practice.system.domain.user.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String phone;

    @NotNull
    private int age;

    @Builder
    public User(String name, String phone, int age) {
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    public void update(String newName, String newPhone, int newAge) {
        this.name = newName;
        this.phone = newPhone;
        this.age = newAge;
    }

    @Override
    public String toString() {
        return "id : " + id +
                ", name : " + name +
                ", phone : " + phone +
                ", age : " + age;
    }
}
