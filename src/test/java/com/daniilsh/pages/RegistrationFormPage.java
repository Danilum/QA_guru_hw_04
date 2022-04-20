package com.daniilsh.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.daniilsh.dataGenerator.GenerateData;
import com.daniilsh.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {
    GenerateData generateData = new GenerateData();
    CalendarComponent calendarComponent = new CalendarComponent();

    SelenideElement fixedbanInput = $("#close-fixedban");
    SelenideElement firstNameInput = $("[id=firstName]");
    SelenideElement lastNameInput = $("[id=lastName]");
    SelenideElement emailInput = $("[id=userEmail]");
    SelenideElement genderInput = $(byText("Male"));
    SelenideElement phoneNumberInput = $("[id=userNumber]");
    SelenideElement dateOfBirthInput = $("[id=dateOfBirthInput]");
    SelenideElement subjectsInput = $("[id = subjectsInput]");
    SelenideElement hobbiesInput = $("#hobbiesWrapper").$(byText("Sports"));
    SelenideElement pictureInput = $("[id = uploadPicture]");
    SelenideElement addressInput = $("#currentAddress");
    SelenideElement city1Input = $("[id = react-select-3-input]");
    SelenideElement city2Input = $("[id = react-select-4-input]");
    SelenideElement submitInput = $("#submit");
    SelenideElement titleInput = $("#example-modal-sizes-title-lg");
    SelenideElement resultsTableInput = $(".table-responsive");

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        fixedbanInput.click();
        Selenide.zoom(0.65);
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender() {
        genderInput.click();
        return this;
    }

    public RegistrationFormPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobbies() {
        hobbiesInput.click();
        return this;
    }

    public RegistrationFormPage setPicture() {
        pictureInput.uploadFromClasspath("test_img.jpg");
        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setCity() {
        city1Input.setValue("n").pressEnter();
        city2Input.setValue("d").pressEnter();
        return this;
    }

    public void submit() {
        submitInput.click();
    }

    public void checkTitle() {
        titleInput.shouldHave(text("Thanks for submitting the form"));
    }

    public void checkResultContent(String fullName, String email, String phoneNumber, String address) {
        resultsTableInput.shouldHave(
                text(fullName),
                text(email),
                text("Male"),
                text(phoneNumber),
                text("12 June,1999"),
                text("Hindi"),
                text("Sports"),
                text("test_img.jpg"),
                text(address),
                text("NCR" + " " + "Delhi")
        );
    }


}
