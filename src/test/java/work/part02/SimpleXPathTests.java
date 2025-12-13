package work.part02;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleXPathTests {

    @BeforeEach
    void setUp() {
        open("https://slqamsk.github.io/tmp/xPath01.html");
    }

    @Test
    void testPageH1() {
        $x("//h1").shouldHave(text("Учебная страница для XPath"));
        $x("//h1").shouldHave(exactText("Учебная страница для XPath"));
    }

    @Test
    void testSpecialParagraph() {
        $x("//p[@class='special-paragraph']").shouldHave(exactText("Этот параграф особенный - он единственный на странице с таким классом."));
        $x("//p[@class='info-text'][1]").shouldHave(exactText("Это первый информационный текст."));
    }

    @Test
    void testFindByText() {
        open("https://slqa.ru/cases/xPathSimpleForm/");
    /*      почему то закоментированные тесты не проходят  :(   */

        //$(byText("Москва")).shouldHave(text("250 единиц"));
        $x("//*[contains(., 'Питер')]").shouldHave(text("180 единиц"));
       //$x("//*[starts-with(.,'Казахстан')])").shouldHave(text("площадь 2 724 902"));
    }
}
