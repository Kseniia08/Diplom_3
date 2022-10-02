import clients.UserClient;
import io.qameta.allure.junit4.DisplayName;
import data.Token;
import data.User;
import data.UserCredentials;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ConstructorTest extends BaseTest {
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
    @DisplayName("Проверка перехода на главную страницу по кнопке Конструктор")
    public void isCorrectGoToMainPageWithPersonalOfficeButtonConstructor() {
        String message = "При попытке перехода из Личного Кабинета на главную страницу по кнопке Конструтор что-то пошло не так";
        String expectedURL = "https://stellarburgers.nomoreparties.site/";
        String actualURL = mainPage.clickButtonLogin()
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickButtonLogin()
                .clickButtonPersonalOffice()
                .clickButtonConstructor()
                .getUrlMainPage();
        assertEquals(message, expectedURL, actualURL);
    }

    @Test
    @DisplayName("Проверка перехода на главную страницу по кнопке Конструктор")
    public void isCorrectGoToMainPageWithPersonalOfficeLogStellarBurgers() {
        String message = "При попытке перехода из Личного Кабинета на главную страницу по кнопке Конструтор что-то пошло не так";
        String expectedURL = "https://stellarburgers.nomoreparties.site/";
        String actualURL = mainPage.clickButtonLogin()
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickButtonLogin()
                .clickButtonPersonalOffice()
                .clickLogoStellarBurgers()
                .getUrlMainPage();
        assertEquals(message, expectedURL, actualURL);
    }

    @Test
    @DisplayName("Проверка, что по умолчанию при переходе на главную страницу выбран раздел Булки")
    public void checkDefaultSelectedSectionBulka() {
        String message = "При проверке выбранного раздела по умолчанию что-то пошло не так";
        String expectedNameSelectedSection = "Булки";
        String actualNameSelectedSection = mainPage.clickButtonLogin()
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickButtonLogin()
                .getNameSelectedSection();
        assertEquals(message, expectedNameSelectedSection, actualNameSelectedSection);
    }

    @Test
    @DisplayName("Проверка перехоа к разделу Булки")
    public void checkSelectionSectionBulka() {
        String message = "При проверке выбора раздела Булки что-то пошло не так";
        String expectedNameSelectedSection = "Булки";
        String actualNameSelectedSection = mainPage.clickButtonLogin()
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickButtonLogin()
                .clickUnselectedSectionFilling()
                .clickUnselectedSectionBulka()
                .getNameSelectedSection();
        assertEquals(message, expectedNameSelectedSection, actualNameSelectedSection);
    }

    @Test
    @DisplayName("Проверка перехоа к разделу Соусы")
    public void checkSelectionSectionSauce() {
        String message = "При проверке выбора раздела Соусы что-то пошло не так";
        String expectedNameSelectedSection = "Соусы";
        String actualNameSelectedSection = mainPage.clickButtonLogin()
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickButtonLogin()
                .clickUnselectedSectionSauce()
                .getNameSelectedSection();
        assertEquals(message, expectedNameSelectedSection, actualNameSelectedSection);
    }

    @Test
    @DisplayName("Проверка перехоа к разделу Начинки")
    public void checkSelectionSectionFilling() {
        String message = "При проверке выбора раздела Начинки что-то пошло не так";
        String expectedNameSelectedSection = "Начинки";
        String actualNameSelectedSection = mainPage.clickButtonLogin()
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickButtonLogin()
                .clickUnselectedSectionFilling()
                .getNameSelectedSection();
        assertEquals(message, expectedNameSelectedSection, actualNameSelectedSection);
    }
}
