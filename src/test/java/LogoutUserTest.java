import clients.UserClient;
import io.qameta.allure.junit4.DisplayName;
import data.Token;
import data.User;
import data.UserCredentials;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LogoutUserTest extends BaseTest {
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
        userClient.delete(token);
    }

    @Test
    @DisplayName("Проверка выхода пользователя по кнопке Выход")
    public void isCorrectGoToMainPageWithPersonalOfficeButtonConstructor() {
        String message = "При попытке выхода пользователя что-то пошло не так";
        String expectedURL = "https://stellarburgers.nomoreparties.site/";
        String actualURL = mainPage.clickButtonLogin()
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickButtonLogin()
                .clickButtonPersonalOffice()
                .clickButtonLogout()
                .getUrlLoginPage();
        assertEquals(message, expectedURL, actualURL);
        token = userClient.login(creds);
    }
}
