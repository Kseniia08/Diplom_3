import clients.UserClient;
import io.qameta.allure.junit4.DisplayName;
import data.Token;
import data.User;
import data.UserCredentials;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LoginUserTest extends BaseTest {
    private UserClient userClient;
    private Token token;
    private UserCredentials creds;
    private User user;

    @Before
    public void setup() {
        userClient = new UserClient();
        user = User.getRandom();
        token = userClient.create(user);
        creds = UserCredentials.from(user);
        userClient.logout(token);
    }

    @After
    public void teardown() {
        token = userClient.login(creds);
        userClient.delete(token);
    }

    @Test
    @DisplayName("Проверка входа по кнопке «Войти в аккаунт» на главной")
    public void isCorrectLoginWithLoginButton() {
        String message = "При попытке логина пользователя по кнопке «Войти в аккаунт» на главной что-то пошло не так";
        String expectedNameButton = "Оформить заказ";
        String actualNameButton = mainPage.clickButtonLogin()
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickButtonLogin().getTextButtonLogin();
        assertEquals(message, expectedNameButton, actualNameButton);
    }

    @Test
    @DisplayName("Проверка входа по кнопке «Личный кабинет» на главной")
    public void isCorrectLoginWithPersonalOffice() {
        String message = "При попытке логина пользователя по кнопке «Личный кабинет» на главной что-то пошло не так";
        String expectedNameButton = "Оформить заказ";
        String actualNameButton = mainPage.clickButtonPersonalOfficeLoginPage()
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickButtonLogin().getTextButtonLogin();
        assertEquals(message, expectedNameButton, actualNameButton);
    }

    @Test
    @DisplayName("Проверка входа по кнопке «Войти» в форме регистрации")
    public void isCorrectLoginViaRegistrationPage() {
        String message = "При попытке логина пользователя по кнопке «Войти» в форме регистрации";
        String expectedNameButton = "Оформить заказ";
        String actualNameButton = mainPage.clickButtonLogin()
                .clickLinkRegistration()
                .clickLinkLogin()
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickButtonLogin().getTextButtonLogin();
        assertEquals(message, expectedNameButton, actualNameButton);
    }

    @Test
    @DisplayName("Проверка входа по кнопке «Войти» на странице восставновления пароля")
    public void isCorrectLoginViaForgotPasswordPage() {
        String message = "При попытке логина пользователя по кнопке «Войти» на странице восставновления пароля";
        String expectedNameButton = "Оформить заказ";
        String actualNameButton = mainPage.clickButtonLogin()
                .clickLinkForgotPassword()
                .clickLinkLogin()
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickButtonLogin().getTextButtonLogin();
        assertEquals(message, expectedNameButton, actualNameButton);
    }
}
