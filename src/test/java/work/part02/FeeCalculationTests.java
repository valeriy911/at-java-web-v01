package work.part02;
import static com.codeborne.selenide.Selenide.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FeeCalculationTests {
    @Test
    public void test01() {
        open("https://slqa.ru/cases/fc/v01/");
        $(By.name("sum")).sendKeys("ТЕКСТ");
        sleep(2_000);
        $(By.name("submit")).click();
        sleep(2_000);
        $(By.name("sum")).clear();
        sleep(2_000);

        $(By.name("sum")).sendKeys("1000");
        sleep(2_000);
        $(By.name("submit")).click();
        sleep(2_000);
    /*    $(By.name("sum")).clear();
        sleep(2_000);*/

        $(By.tagName("input")).setValue("2000");
        sleep(2_000);
        $(By.name("submit")).click();
        sleep(2_000);
    /*    $(By.name("sum")).clear();
        sleep(2_000);*/

    /*   $("input=[sum]").type("4000");
        $(By.tagName("input")).type("2000")
        sleep(2_000);
        $(By.name("submit")).click();
        sleep(2_000);
    */
    }

}