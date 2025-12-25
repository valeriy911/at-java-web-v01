package work.part07.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.Configuration;
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

    @Step("Выбор городов и дат рейсов")
    public void chooseFlight() {
        Configuration.pageLoadStrategy = "eager";
        $(By.name("fromPort")).selectOption(1); // Выбираем Нью-йщрк из списка From:
        $(By.name("fromPort")).selectOption(2); // Выбираем Сидней из списка To:
        // выбираем дату отлета
        $(By.id("departDay")).selectOption(1);  // выбираем 01 из списка Departing:
        $(By.id("departMonth")).selectOption("Feburary 2025");  // выбираем дату обратного рейса
        // выбираем дату обратного рейса
        $(By.id("returnDay")).selectOption(3);
        $(By.id("returnMonth")).selectOption("March 2025");
    }

    @Step("Таблица выбора рейсов появилась")
    public void flightTableShowing() {
        //sleep(2000);
        $(By.id("flights")).shouldBe(visible);
    }





}
