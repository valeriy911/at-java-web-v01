package work.part03;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

public class testxPathAddPizza {
    @Test
    void testxPathAddPizza() {
        //https://slqamsk.github.io/cases/pizza/v08/ -
        // написать автотест, который добавит пиццы "Маргарита" и "Четыре сыра" в корзину,
        // не пользуясь атрибутом data-id.
        open("https://slqamsk.github.io/cases/pizza/v08/");
        SelenideElement se1 = $x("//h3[.='Маргарита']");
        System.out.println("Элемент с названием пиццы: тег: " + se1.getTagName() + ", текст: " + se1.text());
        SelenideElement se2 = $x("//h3[.='Маргарита']/..");
        System.out.println("Его родитель: тег: " + se2.getTagName() + ", текст: " + se2.text());
        SelenideElement se3 = $x("//h3[.='Маргарита']/../button");
        System.out.println("Кнопка: тег: " + se3.getTagName() + ", текст: " + se3.text());
    }

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
