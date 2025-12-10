package demo.part02;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class NavigationTests {
    @Test
    void testNavigation() {
        Configuration.browser = "firefox";
        open("https://ya.ru/");
        sleep(9_000);
        open("https://ru.wikipedia.org");
        sleep(9_000);
        open("https://ru.wikipedia.org/wiki/Selenium");
        sleep(9_000);
        back();
        sleep(9_000);
        back();
        sleep(9_000);
        forward();
        sleep(10_000);
    }
}
