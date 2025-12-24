package work.part07;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)

public class SimpleTravelAgilewayTest {
    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setUp() {  // открываем страницу, грузим веб-драйвер, максимизируем окно со страницей
        Configuration.browser = "firefox";
        //getWebDriver().manage().window().maximize();
        open("https://travel.agileway.net");
    }

    //  пошли автотесты
    //  1. Успешная авторизация
    @Test
    void test01LoginSuccess() {
        $(By.id("username")).sendKeys("agileway");
        $(By.id("password")).setValue("test$W1se");
        $(By.name("commit")).click();
        $(By.id("user_nav")).shouldHave(text("Welcome")); // проверка успешной авторизации по приветствию в хедере

    }

    //  2. Неуспешная авторизация с неправильным паролем
    @Test
    void test02LoginWrongPassword() {
        $(By.id("username")).sendKeys("agileway");
        $(By.id("password")).setValue("99test$W1se");
        $(By.name("commit")).click();
        $(By.id("flash_alert")).shouldHave(text("Invalid email or password")); // проверка неуспешной авторизации по предупредительному сообщению
    }

    //  3. Успешный Log_out
    @Test
    void test03LogOUTSuccess() {
        // сперва авторизуемся
        $(By.id("username")).sendKeys("agileway");
        $(By.id("password")).setValue("test$W1se");
        $(By.name("commit")).click();
        // а теперь давим по ссылке Sign off, но придется воспользоваться XPass, иначе не получается
        $x("//a").click();
        $(By.id("flash_notice")).shouldHave(text("Signed out!"));
    }

    //  4. Переход на страницу регистрации (типа) :)
    @Test
    void test04RegistrationPageSuccess() {
        //$x("//a[contains(., 'Register')]").click();
        $x("/html/body/div/div[1]/a[1]").click(); // с абсолютным Xpass мы тоже могём ))
        sleep(2000);
        $(By.className("translation_missing")).shouldHave(text("Heading New Staff"));
        // только вот к регистрации эта страница не имеет отношения :)
    }

}











