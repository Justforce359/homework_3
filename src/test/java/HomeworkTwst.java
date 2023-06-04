package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
public class HomeworkTwst {


    @Test
    void SuccesfulTest () {
        Configuration.browserSize = "1920x1080";
        //открыть страницу https://demoqa.com/automation-practice-form
        open("https://demoqa.com/automation-practice-form");
        //заполнить форму FirstName
        $("#firstName").setValue("Mikhail");
        //заполнить форму LastName
        $("#lastName").setValue("Ustinov");
        //заполнить форму Email
        $("#userEmail").setValue("dsvsdv@mail.com");
        //заполнить форму Gender
        $("#genterWrapper").$(byText("Male")).click();
        //заполнить форму Mobile(10 Digits)
        $("#userNumber").setValue("1234567890");
        //заполнить форму Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("May")).click();
        $(".react-datepicker__year-dropdown-container").$(byText("1986")).click();
        $(".react-datepicker__month").$(byText("10")).click();
        //заполнить форму Subjects
        $("#subjectsInput").setValue("Maths").pressEnter();
        //заполнить форму Hobbies
        $("#hobbiesWrapper").$(byText("Reading")).click();
        //заполнить форму Picture
        $("#uploadPicture").uploadFromClasspath("picture.png");
        //заполнить форму Current Address
        $("#currentAddress").setValue("fbv;oksdfolibvjsdifb");
        //заполнить форму State and City
        $("#state").click();
        $("#state").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#city").$(byText("Agra")).click();
        // нажать кнопку Submit
        $("#submit").click();
        // Проверить корректность данных заполенных форм
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Mikhail Ustinov"));
        $(".modal-body").shouldHave(text("dsvsdv@mail.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("1234567890"));
        $(".modal-body").shouldHave(text("10 May,1986"));
        $(".modal-body").shouldHave(text("Maths"));
        $(".modal-body").shouldHave(text("Reading"));
        $(".modal-body").shouldHave(text("picture.png"));
        $(".modal-body").shouldHave(text("fbv;oksdfolibvjsdifb"));
        $(".modal-body").shouldHave(text("Uttar Pradesh"));
        $(".modal-body").shouldHave(text("Agra"));
        $("#closeLargeModal").click();
    }
}
