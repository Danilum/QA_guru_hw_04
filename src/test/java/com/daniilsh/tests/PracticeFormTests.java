package com.daniilsh.tests;

import com.codeborne.selenide.Configuration;
import com.daniilsh.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static java.lang.String.format;

public class PracticeFormTests {

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            address = faker.address().secondaryAddress(),
            phoneNumber = faker.number().digits(10),
            fullName = format("%s %s", firstName, lastName);

    @BeforeAll
    static void setUp(){
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillPracticeFormTest(){
        RegistrationFormPage registrationFormPage = new RegistrationFormPage();
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender()
                .setPhoneNumber(phoneNumber)
                .setDateOfBirth("12", "June", "1999")
                .setSubject("h")
                .setHobbies()
                .setPicture()
                .setAddress(address)
                .setCity()
                .submit();

        registrationFormPage.checkTitle();
        registrationFormPage.checkResultContent(fullName, email, phoneNumber,address);
    }
}
