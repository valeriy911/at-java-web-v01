package work.part02;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import org.junit.jupiter.api.Test;

public class SimpleXPathTests {
    @Test
    void testPageH1() {
        open("https://slqamsk.github.io/tmp/xPath01.html");
        $x("//h1").shouldHave(text("Учебная страница для XPath"));
        $x("//h1").shouldHave(exactText("Учебная страница для XPath"));
    }
}
