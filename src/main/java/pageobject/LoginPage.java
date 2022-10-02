package pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.WebDriverRunner.url;

public class LoginPage {
    // локатор ссылки "Регистрация" внизу страницы
    @FindBy(how = How.XPATH, using = ".//*[text()='Зарегистрироваться']")
    private SelenideElement linkRegistration;
    // локатор поля ввода "пароль"
    @FindBy(how = How.XPATH, using = ".//*[@type='password']")
    private SelenideElement fieldInputPassword;
    // локатор поля ввода "email"
    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement fieldInputName;
    // локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = ".//*[text()='Войти']")
    private SelenideElement buttonLogin;
    // локатор ссылки "Восстановить пароль" внизу страницы
    @FindBy(how = How.XPATH, using = ".//*[text()='Восстановить пароль']")
    private SelenideElement linkForgotPassword;

    @Step("метод клика по ссылки Регистрация на странице логина")
    public RegistrationPage clickLinkRegistration() {
        linkRegistration.click();
        return Selenide.page(RegistrationPage.class);
    }

    @Step ("метод ввода в поле email")
    public LoginPage inputEmail(String email) {
        fieldInputName.setValue(email);
        return this;
    }

    @Step ("метод ввода в поле Пароль")
    public LoginPage inputPassword(String password) {
        fieldInputPassword.setValue(password);
        return this;
    }

    @Step ("метод клика по кнопке Войти")
    public MainPage clickButtonLogin() {
        buttonLogin.click();
        return Selenide.page(MainPage.class);
    }

    @Step ("метод клика по ссылке Восстановить пароль")
    public ForgotPasswordPage clickLinkForgotPassword() {
        linkForgotPassword.click();
        return Selenide.page(ForgotPasswordPage.class);
    }

    public String getUrlLoginPage() {
        return url();
    }
}
