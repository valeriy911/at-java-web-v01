
package demo.part07.pages;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class LoginPage {

    SelenideElement
        username = $("#username"),
        password = $("#password"),
        loginButton = $("#loginButton"),
        message = $("#message"),
        greeting = $("#greeting");

    @Step("Вход в систему")
    public void login(String username, String password) {

    }

    @Step("Неуспешный логин")
    public  void isLoginUnsuccessful(){
        message.shouldHave(text("Неверное имя пользователя или пароль."));
    }



    @Step("Успешный логин")
    public void isLoginSuccessful(String fio) {
        this.greeting.shouldHave(text("Добро пожаловать, " + fio + "!"));
    }

    public void isLoginSuccessful() {
        $x("//a").click();
    }
}