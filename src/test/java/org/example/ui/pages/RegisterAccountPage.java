package org.example.ui.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class RegisterAccountPage {
    SelenideElement firstNameInput = element(Selectors.byId("customer.firstName"));

    SelenideElement lastNameInput = element(Selectors.byId("customer.lastName"));

    //добавить все важные элементы веб-странички В ПОЛЯ

    SelenideElement registerButton = element(Selectors.byValue("Register"));

    public void register(String firstName, String lastName){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);

        registerButton.click();
    }

}
