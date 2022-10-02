package pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalOfficePage {
    // локатор текста «В этом разделе вы можете изменить свои персональные данные»
    @FindBy(how = How.XPATH, using = ".//*[@class='Account_text__fZAIn text text_type_main-default']")
    private SelenideElement textFieldPersonalOffice;
    // локатор кнопки «Конструктор»
    @FindBy(how = How.XPATH, using = ".//*[@class='AppHeader_header__linkText__3q_va ml-2'][text()='Конструктор']")
    private SelenideElement buttonConstructor;
    // локатор логотипа Stellar Burgers
    @FindBy(how = How.XPATH, using = ".//*[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logoStellarBurgers;
    // локатор кнопки «Выход»
    @FindBy(how = How.XPATH, using = ".//*[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']")
    private SelenideElement buttonLogout;


    @Step("метод получения текста «В этом разделе вы можете изменить свои персональные данные» в Личном кабинете")
    public String getTextPersonalOffice() {
        String textPersonalOffice = textFieldPersonalOffice.getText();
        return textPersonalOffice;
    }

    @Step ("метод клика по кнопке «Конструктор» на странице личного кабинета с переходом на главную страницу")
    public MainPage clickButtonConstructor() {
        buttonConstructor.click();
        return Selenide.page(MainPage.class);
    }

    @Step ("метод клика по логотипу  Stellar Burgers на странице личного кабинета с переходом на главную страницу")
    public MainPage clickLogoStellarBurgers() {
        logoStellarBurgers.click();
        return Selenide.page(MainPage.class);
    }

    @Step ("метод клика по кнопке «Выход» на странице личного кабинета с переходом на страницу логина")
    public LoginPage clickButtonLogout() {
        buttonConstructor.click();
        return Selenide.page(LoginPage.class);
    }
}
