package data;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
public class User {
    private String email;
    private String password;
    private String name;

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public static User getRandom() {
        String email = RandomStringUtils.randomAlphabetic(5).toLowerCase() + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(10);
        String name = RandomStringUtils.randomAlphabetic(10);
        return new User(email, password, name);
    }

    public static User getRandomShortPassword() {
        String email = RandomStringUtils.randomAlphabetic(5).toLowerCase() + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(5);
        String name = RandomStringUtils.randomAlphabetic(10);
        return new User(email, password, name);
    }
}

