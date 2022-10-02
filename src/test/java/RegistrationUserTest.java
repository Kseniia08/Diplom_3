import clients.UserClient;
import io.qameta.allure.junit4.DisplayName;
import data.Token;
import data.User;
import data.UserCredentials;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RegistrationUserTest extends BaseTest {
    private UserClient userClient;

    @Before
    public void setup() {
        userClient = new UserClient();
    }

    @Test
    @DisplayName("Проверка успешной регистрации пользователя с корректным логином, паролем и именем")
    public void isCorrectRegistrationUser() {
        String message = "При попытке регистрации пользователя с корректными данными что-то пошло не так";
        String expectedNameButton = "Оформить заказ";
        User user = User.getRandom();
        UserCredentials creds = UserCredentials.from(user);
        String actualNameButton = mainPage.clickButtonLogin()
                .clickLinkRegistration()
                .inputName(user.getName())
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickButtonRegistration()
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickButtonLogin().getTextButtonLogin();
        Token token = userClient.login(creds);
        userClient.delete(token);
        assertEquals(message, expectedNameButton, actualNameButton);
    }

    @Test
    @DisplayName("Проверка отображения корректной ошибки при регистрации пользователя с коротким паролем")
    public void isRegistrationFailedShortPassword() {
        String message = "При попытке регистрации пользователя с коротким паролем что-то пошло не так";
        String expectedError = "Некорректный пароль";
        User user = User.getRandomShortPassword();
        String actualError = mainPage.clickButtonLogin()
                .clickLinkRegistration()
                .inputName(user.getName())
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickButtonRegistrationError()
                .getTextErrorBadPassword();
        assertEquals(message, expectedError, actualError);
    }
}
