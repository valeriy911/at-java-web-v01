package demo.part02;
<<<<<<< HEAD
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
=======
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
public class NavigationTests {
    @Test
    void testNavigation() {
        open("https://ya.ru/");
        sleep(10_000);
        open("https://ru.wikipedia.org");
        sleep(3_000);
        open("https://ru.wikipedia.org/wiki/Selenium");
        sleep(3_000);
        back();
        sleep(3_000);
        back();
        sleep(3_000);
        forward();
        sleep(10_000);
    }
}
>>>>>>> 7ceb2a0e7f23416a6ee29fa2200ccdb57c312abc
