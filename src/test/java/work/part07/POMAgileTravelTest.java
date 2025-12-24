package work.part07;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.openqa.selenium.By;
import work.part07.pages.LoginPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import work.part07.pages.LoginPage;
import work.part07.pages.RegistrationUserPage;


@TestMethodOrder(MethodOrderer.DisplayName.class)
public class POMAgileTravelTest {

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setUp() {  // открываем страницу, грузим веб-драйвер, максимизируем окно со страницей
        Configuration.browser = "firefox"; // сайт почему-то запускается только под FireFox ((
        //getWebDriver().manage().window().maximize();
        open("https://travel.agileway.net/login");
    }

    // ... Автотесты
    //  1. Успешная авторизация
     @Test
    void test01LoginSuccess() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("agileway", "test$W1se");
        loginPage.isLoginSuccessful();
        //loginPage.logout();
    }

    //  2. Неуспешная авторизация с неправильным паролем
    @Test
    void test02LoginWrongPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("agileway", "WRONG_PASSWORD");
        loginPage.isLoginUnsuccessful();
    }

    //  3. Успешный Log_out
    @Test
    void test03LogOUTSuccess() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("agileway", "test$W1se");
        loginPage.logout();
        $(By.id("flash_notice")).shouldHave(text("Signed out!"));
    }

    //  4. Переход на страницу регистрации нового пользователя
    // только вот к регистрации эта страница не имеет отношения :)
    @Test
    void test04RegistrationPageSuccess() {
        RegistrationUserPage regPage = new RegistrationUserPage();
        regPage.gotoRegPage(); // переходим по ссылке "Register" в заголовке страницы
        regPage.gotoRegPageSuccessful();
    }



}
