package work.part01;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

public class HomeWork1 {
    @Test
    void test01() {
        open("https://ru.wikipedia.org/wiki/Selenium");
        $("body").shouldHave(text("WebDriver"));
    }
    @Test
    void test02() {
        open("https://ru.wikipedia.org/wiki/Selenium");
        $("body").shouldHave(text("Selenide"));
    }
    @Test
    void test03() {
        open("https://slqa.ru/cases/SimpleForm/");
        $("body").shouldHave(text("Томас Фуллер"));
    }
    @Test
    void test04() {
        open("http://92.51.36.108:7777/sl.qa");
        $("body").shouldHave(text("Учебные приложения"));
    }
    @Test
    void test05() {
        open("http://92.51.36.108:7777/sl.qa");
        $("body").shouldHave(text("Промышленные приложения"));
    }
     @Test
     void test_browser_properties() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1500x500";
        Configuration.browserPosition = "100x200";
        open("https://ya.ru");
        sleep(10_000);
        getWebDriver().manage().window().maximize();
        sleep(10_000);
    }
    @Test
    void my_test_browser_properties() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "800x600";
        Configuration.browserPosition = "100x100";
        open("https://ozon.ru");
        sleep(7_000);
        getWebDriver().manage().window().maximize();
        sleep(7_000);
    }

}
