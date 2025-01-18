package org.example.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.example.ui.pages.datas.BankAccount;

import static com.codeborne.selenide.Selenide.element;

@Getter
public class RegisterAccountPage {
    private SelenideElement firstNameInput = element(Selectors.byId("customer.firstName"));

    private SelenideElement lastNameInput = element(Selectors.byId("customer.lastName"));

    //добавить все важные элементы веб-странички В ПОЛЯ

    private SelenideElement registerButton = element(Selectors.byValue("Register"));

    //Дальше идут поля ошибок
    private SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));

    private SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));

    private SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));

    private SelenideElement zipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));

    private SelenideElement phoneNumber = element(Selectors.byId("customer.phoneNumber"));

    private SelenideElement phoneNumber1 = element(Selectors.byId("customer.phoneNumber"));

    private SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));

    private SelenideElement usernameError = element(Selectors.byId("customer.username.errors"));

    private SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));

    private SelenideElement passwordConfirmationError = element(Selectors.byId("repeatedPassword.errors"));

    //много ошибок

    public void open(){
        Selenide.open("/parabank/register.htm");
    }

    public void register(BankAccount bankAccount){
        firstNameInput.sendKeys(bankAccount.getFirstName());
        lastNameInput.sendKeys(bankAccount.getLastName());


        registerButton.click();
    }

}
