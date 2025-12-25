package work.part07.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

// тут будут методы для работы со страницей Passenger Details
// https://travel.agileway.net/flights/....
public class PassengerDetailsPage {

    @Step("Проверка перехода на страницу")
    public void checkPassengerDetailsPage() {
        $(By.tagName("h2")).shouldHave(text("Passenger Details"));
    }
}
