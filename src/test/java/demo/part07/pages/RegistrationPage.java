<<<<<<< HEAD:src/test/java/demo/part05/pages/RegistrationPage.java
package demo.part05.pages;
=======
package demo.part07.pages;
>>>>>>> 014f053c3a7cc9593f8e3a781ad1bf2fde02de85:src/test/java/demo/part07/pages/RegistrationPage.java

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationPage {
    SelenideElement
            flightInfo = $("#flightRegistrationInfo"),
            buttonFinishRegistration = $x("//button[contains(.,'Завершить регистрацию')]"),
            fio = $("#passengerName"),
            passport = $("#passportNumber"),
            email = $("#email"),
            phone = $("#phone"),
            message = $("#registrationMessage");


    @Step("Проверка, что данные рейса корректные")
    public void isFlightDataCorrect(String cityFrom, String cityTo) {
        flightInfo
                .shouldBe(visible)
                .shouldHave(text(cityFrom + " → " + cityTo));
    }

    @Step("Успешная регистрация со значениями по умолчанию")
    public void successDefaultRegistration() {
        buttonFinishRegistration.click();
        Alert alert= switchTo().alert();
        assertTrue(alert.getText().contains("Бронирование завершено"));
        alert.accept();
        this.message.shouldHave(text("Регистрация успешно завершена!"));
    }

    @Step("Заполнение полей и регистрация")
    public void registration(String fio, String passport, String email, String phone) {
        this.fio.setValue(fio);
        this.passport.setValue(passport);
        this.email.setValue(email);
        this.phone.setValue(phone);
        buttonFinishRegistration.click();
    }

    @Step("Появилась ошибка Заполните все поля")
    public void isErrorFillAllFied() {
        this.message.shouldHave(text("Пожалуйста, заполните все поля."));
    }
}