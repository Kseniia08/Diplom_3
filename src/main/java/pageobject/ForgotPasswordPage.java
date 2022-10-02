package pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {
    // локатор кнопки «Войти»
    @FindBy(how = How.XPATH, using = ".//*[text()='Войти']")
    private SelenideElement linkLogin;

    @Step("метод клика по ссылке Войти")
    public LoginPage clickLinkLogin() {
        linkLogin.click();
        return Selenide.page(LoginPage.class);
    }
}
