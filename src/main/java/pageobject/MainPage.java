package pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.WebDriverRunner.url;

public class MainPage {
    final static public String URL = "https://stellarburgers.nomoreparties.site/";
    // локатор кнопки "Войти в аккаунт" / "Оформить заказ"
    @FindBy(how = How.XPATH, using = ".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement buttonLogin;
    // локатор кнопки «Личный кабинет»
    @FindBy(how = How.XPATH, using = ".//*[@class='AppHeader_header__linkText__3q_va ml-2'][text()='Личный Кабинет']")
    private SelenideElement buttonPersonalOffice;
    // локатор невыбранного раздела Булки
    @FindBy(how = How.XPATH, using = ".//*[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']")
    private SelenideElement unselectedSectionBulka;
    // локатор невыбранного раздела Соусы
    @FindBy(how = How.XPATH, using = ".//*[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']")
    private SelenideElement unselectedSectionSauce;
    // локатор невыбранного раздела Начинки
    @FindBy(how = How.XPATH, using = ".//*[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']")
    private SelenideElement unselectedSectionFilling;
    // локатор выбранного раздела
    @FindBy(how = How.XPATH, using = ".//*[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']")
    private SelenideElement selectedSection;

    @Step("метод клика по кнопке-ссылки Регистрация на главной странице")
    public LoginPage clickButtonLogin() {
        buttonLogin.click();
        return Selenide.page(LoginPage.class);
    }

    @Step ("метод получения текста кнопки на главной странице")
    public String getTextButtonLogin() {
        String textButton = buttonLogin.getText();
        return textButton;
    }

    @Step ("метод клика по кнопке «Личный кабинет» на главной странице с переходом на страницу Логина")
    public LoginPage clickButtonPersonalOfficeLoginPage() {
        buttonPersonalOffice.click();
        return Selenide.page(LoginPage.class);
    }

    @Step ("метод клика по кнопке «Личный кабинет» на главной странице с переходом в Личный кабинет")
    public PersonalOfficePage clickButtonPersonalOffice() {
        buttonPersonalOffice.click();
        return Selenide.page(PersonalOfficePage.class);
    }

    public String getUrlMainPage() {
        return url();
    }

    @Step ("метод клика по невыбранному разделу Булка")
    public MainPage clickUnselectedSectionBulka() {
        unselectedSectionBulka.click();
        return Selenide.page(MainPage.class);
    }

    @Step ("метод клика по невыбранному разделу Соусы")
    public MainPage clickUnselectedSectionSauce() {
        unselectedSectionSauce.click();
        return Selenide.page(MainPage.class);
    }

    @Step ("метод клика по невыбранному разделу Начинки")
    public MainPage clickUnselectedSectionFilling() {
        unselectedSectionFilling.click();
        return Selenide.page(MainPage.class);
    }

    @Step ("метод получения имени выбранного раздела")
    public String getNameSelectedSection() {
        return selectedSection.getText();
    }
}
