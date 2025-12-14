package work.part03;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

public class testHWcpecialist {
    @Test
    void testHWspecialist() {
        open("https://www.specialist.ru/");
        sleep(2_000);
        $x("//button[@id='cookieConsent__ok']").click();
        sleep(2_000);
        $x("//a[.='Курсы']").click();
        sleep(2_000);
        $x("//a[.='Каталог курсов']").click();
        sleep(10_000);

        //$("#CourseName").sendKeys("тестирование");
        $x("//input[@id='CourseName']").sendKeys("тестирование");
        $x("//button[@type='submit']").click();

        String myXPath = "//*[contains(text(),'Автоматизированное тестирование веб-приложений с использованием Selenium')]/ancestor::article//dd[contains(@class,'date-start') and contains(@class,'date')]";
        SelenideElement se = $x(myXPath);
        se.shouldHave(text("24.01.2026"));
    }
}
