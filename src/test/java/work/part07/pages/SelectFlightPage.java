package work.part07.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

// тут будут методы для работы со страницей Select Flight
// https://travel.agileway.net/flights/start

public class SelectFlightPage {

    @Step("Выбор полета в одну сторону")
    public void oneWayButton() {
        // давим по радиокнопку  One way
        $x("//input[@name='tripType' and @value='oneway']").click();
    }

    @Step("Поле обратного рейса исчезло")
    public void oneWaySuccessful() {
        $(By.id("returnTrip")).shouldNot(visible);
    }



}
