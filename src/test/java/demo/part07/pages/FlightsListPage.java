<<<<<<< HEAD:src/test/java/demo/part05/pages/FlightsListPage.java
package demo.part05.pages;
=======
package demo.part07.pages;
>>>>>>> 014f053c3a7cc9593f8e3a781ad1bf2fde02de85:src/test/java/demo/part07/pages/FlightsListPage.java

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class FlightsListPage {
    SelenideElement
            flightsTable = $("#flightsTable"),
            registerButton = $x("//button[.='Зарегистрироваться']");

    @Step("Выбираем первый рейс в списке")
    public void registerToFirstFlight() {
        this.registerButton.click();
    }

    @Step("Проверяем, что рейсов не найдено")
    public void isNoFlights() {
        flightsTable.shouldHave(text("Рейсов по вашему запросу не найдено."));
    }
}