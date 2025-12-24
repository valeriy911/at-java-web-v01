package work.part07.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class RegistrationUserPage {

    SelenideElement

            regLink  = $x("//a[contains(., 'Register')]"),
            greeting = $(By.className("translation_missing"));


    @Step("Вход в систему")
    public void gotoRegPage() {
        regLink.click();
    }

    @Step("Успешный переход на страницу регистрации нового пользователя")
    // только вот к регистрации эта страница не имеет отношения :)
    public void gotoRegPageSuccessful() {
        greeting.shouldHave(text("Heading New Staff"));
    }
}
