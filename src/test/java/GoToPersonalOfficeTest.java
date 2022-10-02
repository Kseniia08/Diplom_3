import clients.UserClient;
import io.qameta.allure.junit4.DisplayName;
import data.Token;
import data.User;
import data.UserCredentials;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GoToPersonalOfficeTest extends BaseTest {
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
    @DisplayName("Проверка перехода в личный кабинет по кнопке «Личный кабинет» на главной")
    public void isCorrectGotoPersonalOffice() {
        String message = "При попытке перехода в личный кабинет по кнопке на главной что-то пошло не так";
        String expectedText = "В этом разделе вы можете изменить свои персональные данные";
        String actualText = mainPage.clickButtonPersonalOfficeLoginPage()
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickButtonLogin()
                .clickButtonPersonalOffice()
                .getTextPersonalOffice();
        assertEquals(message, expectedText, actualText);
    }
}
