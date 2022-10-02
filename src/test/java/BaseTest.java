import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import pageobject.MainPage;

public class BaseTest {
    MainPage mainPage;

    @Before
    public void setBrowser() {
        //Configuration.browser = "safari";
        WebDriverManager.chromedriver().setup();
        Configuration.startMaximized = true;
        mainPage = Selenide.open(MainPage.URL, MainPage.class);
    }
}
