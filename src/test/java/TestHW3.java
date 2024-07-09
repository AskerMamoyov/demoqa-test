import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestHW3 {

@BeforeAll
static void settings() {
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.pageLoadStrategy = "eager";
    Configuration.timeout = 5000;
}
@Test
void fillFormTest() {
    open("/automation-practice-form");
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");
    $("#firstName").setValue("Name");
    $("#lastName").setValue("Lastname");
    $("#userEmail").setValue("user@email.com");

    $("#genterWrapper").$(byText("Other")).click();

    $("#userNumber").setValue("0123456789");

    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOptionByValue("4");
    $(".react-datepicker__year-select").selectOptionByValue("1995");
    $(".react-datepicker__day--023").click();

    $("#subjectsInput").setValue("C").sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

    $("#hobbiesWrapper").$(byText("Sports")).click();

    $("#uploadPicture").uploadFromClasspath("images.jpeg");

    $("#currentAddress").setValue("somewhere");

    $("#state").click();
    $("#stateCity-wrapper").$(byText("Haryana")).click();
    $("#city").click();
    $("#stateCity-wrapper").$(byText("Panipat")).click();
    $("#submit").click();


    $(".table").shouldHave(text("Student Name Name Lastname"));
    $(".table").shouldHave(text("Student Email user@email.com"));
    $(".table").shouldHave(text("Gender Other"));
    $(".table").shouldHave(text("Mobile 0123456789"));
    $(".table").shouldHave(text("Date of Birth 23 May,1995"));
    $(".table").shouldHave(text("Subjects Chemistry"));
    $(".table").shouldHave(text("Hobbies Sports"));
    $(".table").shouldHave(text("Picture images.jpeg"));
    $(".table").shouldHave(text("Address somewhere"));
    $(".table").shouldHave(text("State and City Haryana Panipat"));
}
}
