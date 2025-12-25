package work.part07;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
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

    // 5.Страница Select Flight - проверка на изчезание поля ввода обратного рейса
    // при выборе радиобаттона "One way"
    @Test
    void test05BackFlightHide() {
        $(By.id("username")).sendKeys("agileway"); // логинимся и переходим на страницу выбора рейса
        $(By.id("password")).setValue("test$W1se");
        $(By.name("commit")).click();

        $x("//input[@name='tripType' and @value='oneway']").click();
        $(By.id("returnTrip")).shouldNot(visible);

    }

    // 6.Страница Select Flight - при заполнении всех параметров рейса
    // внизу должна появиться таблица с предложенными вариантами рейсов
    @Test
    void test06FlightTableShow() {
        $(By.id("username")).sendKeys("agileway"); // логинимся и переходим на страницу выбора рейса
        $(By.id("password")).setValue("test$W1se");
        $(By.name("commit")).click();

        Configuration.pageLoadStrategy = "eager";
        $(By.name("fromPort")).selectOption(1); // Выбираем Нью-йщрк из списка From:
        $(By.name("fromPort")).selectOption(2); // Выбираем Сидней из списка To:
        // выбираем дату отлета
        $(By.id("departDay")).selectOption(1);  // выбираем 01 из списка Departing:
        $(By.id("departMonth")).selectOption("Feburary 2025");  // выбираем дату обратного рейса
        // выбираем дату обратного рейса
        $(By.id("returnDay")).selectOption(3);
        $(By.id("returnMonth")).selectOption("March 2025");
       // $(By.tagName("input")).click();
        sleep(5000);

        $(By.id("flights")).shouldBe(visible); // и тут должна появиться таблица с вариантами рейсов
    }

    // 7. Переход на страницу Passenger Details - заполняются все поля формы на
    // странице Select Flight, выбирается авиакомпания  из таблицы и давится кнопка Continue
    @Test
    void test07GoToPassengerDetailsPage() {
        $(By.id("username")).sendKeys("agileway"); // логинимся и переходим на страницу выбора рейса
        $(By.id("password")).setValue("test$W1se");
        $(By.name("commit")).click();

        Configuration.pageLoadStrategy = "eager";

        $(By.name("fromPort")).selectOption(1);  // выбираем пункты назначения
        $(By.name("fromPort")).selectOption(2);
        $(By.id("departDay")).selectOption(1);   // выбираем даты полетов
        $(By.id("departMonth")).selectOption("Feburary 2025");
        $(By.id("returnDay")).selectOption(3);
        $(By.id("returnMonth")).selectOption("March 2025");

        // выбираем рейс из списка (2-й, Virgin Australia)
        //$x("//input[@type='checkbox'][2]").click();
        //$(By.tagName("input")).click();
        // но я так  и не нашел спооб нажать на чекбокс :((((

        $x("//input[@value='Continue']").click();// давим не кнопку "Continue"
        $(By.tagName("h2")).shouldHave(text("Passenger Details"));
    }


}











