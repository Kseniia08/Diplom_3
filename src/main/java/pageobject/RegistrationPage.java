package pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {
    // локатор полей ввода Имя/email/Пароль
    @FindBy(how = How.XPATH, using = ".//*[@class='text input__textfield text_type_main-default']")
    private ElementsCollection fieldInputUserData;
    // локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement buttonRegistration;
    // локатор ошибки при ввое некоррткного пароля
    @FindBy(how = How.XPATH, using = ".//*[@class='input__error text_type_main-default']")
    private SelenideElement textErrorBadPassword;
    // локатор кнопки «Войти»
    @FindBy(how = How.XPATH, using = ".//*[text()='Войти']")
    private SelenideElement linkLogin;

    @Step ("метод ввода в поле Имя")
    public RegistrationPage inputName(String name) {
        fieldInputUserData.get(0).setValue(name);
        return this;
    }

    @Step ("метод ввода в поле email")
    public RegistrationPage inputEmail(String email) {
        fieldInputUserData.get(1).setValue(email);
        return this;
    }

    @Step ("метод ввода в поле Пароль")
    public RegistrationPage inputPassword(String password) {
        fieldInputUserData.get(2).setValue(password);
        return this;
    }

    @Step ("метод клика по кнопке Зарегистрироваться с переходом на страницу логина")
    public LoginPage clickButtonRegistration() {
        buttonRegistration.click();
        return Selenide.page(LoginPage.class);
    }

    @Step ("метод клика по кнопке Зарегистрироваться с появлением ошибок в заполненных полях")
    public RegistrationPage clickButtonRegistrationError() {
        buttonRegistration.click();
        return this;
    }

    @Step ("метод получения текста ошибки при некорректном пароле")
    public String getTextErrorBadPassword() {
        String textError = textErrorBadPassword.getText();
        return textError;
    }

    @Step ("метод клика по ссылке Войти")
    public LoginPage clickLinkLogin() {
        linkLogin.click();
        return Selenide.page(LoginPage.class);
    }
}
