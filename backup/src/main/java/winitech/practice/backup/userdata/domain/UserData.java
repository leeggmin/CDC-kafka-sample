package winitech.practice.backup.userdata.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserData {

    @Id
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String phone;

    @NotNull
    private int age;

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
