package com.justforge359;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillApplicantFormTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/";
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }


    @Test
    void successfulTest() {
        open("automation-practice-form");
        $("#firstName").setValue("Mikhail");
        $("#lastName").setValue("Ustinov");
        $("#userEmail").setValue("dsvsdv@mail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("May")).click();
        $(".react-datepicker__year-dropdown-container").$(byText("1986")).click();
        $(".react-datepicker__month").$(byText("10")).click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("picture.png");
        $("#currentAddress").setValue("fbv;oksdfolibvjsdifb");
        $("#state").click();
        $("#state").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#city").$(byText("Agra")).click();
        $("#submit").click();
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
