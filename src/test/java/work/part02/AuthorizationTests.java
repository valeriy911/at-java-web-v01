package work.part02;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AuthorizationTests {
    @Test
    public void test01LoginSuccess() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $(By.id("username")).sendKeys("standard_user");
        $(By.id("password")).sendKeys("stand_pass1");
        $(By.id("loginButton")).click();
        $(By.className("greeting")).shouldBe(visible); // проверка успешной авторизации по приветствию в хедере
        sleep(2_000);
    }
    @Test
    public void test02LoginSuccess() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $(By.id("username")).sendKeys("standard_user");
        $(By.id("password")).sendKeys("stand_pass1");
        $(By.id("loginButton")).click();
        $(By.id("logoutButton")).shouldBe(visible);// проверка успешной авторизации по наличию кнопки logout
        sleep(2_000);
    }
    @Test
    public void test03LoginSuccess() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $(By.id("username")).sendKeys("standard_user");
        $(By.id("password")).sendKeys("stand_pass1");
        $(By.id("loginButton")).click();
        $(By.id("flightForm")).shouldBe(exist);// проверка успешной авторизации по наличию формы заказа билетов
        sleep(2_000);
    }
    @Test
    public void test04LoginWrongPassword() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $(By.id("username")).sendKeys("standard_user");
        $(By.id("password")).sendKeys("wefdfv");
        $(By.id("loginButton")).click();
        $(By.className("error")).shouldBe(exist);// проверка безуспешной авторизации по наличию сообщения об ошибке
        $("body").shouldHave(text("Неверное имя пользователя или пароль."));
        sleep(2_000);
    }

}