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
    private SelenideElement addressInput = element(Selectors.byId("customer.address.street")); // <-- добавлено
    private SelenideElement cityInput = element(Selectors.byId("customer.address.city")); // <-- добавлено
    private SelenideElement stateInput = element(Selectors.byId("customer.address.state")); // <-- добавлено
    private SelenideElement zipCodeInput = element(Selectors.byId("customer.address.zipCode")); // <-- добавлено
    private SelenideElement phoneNumberInput = element(Selectors.byId("customer.phoneNumber")); // <-- добавлено
    private SelenideElement ssnInput = element(Selectors.byId("customer.ssn")); // <-- добавлено
    private SelenideElement usernameInput = element(Selectors.byId("customer.username")); // <-- добавлено
    private SelenideElement passwordInput = element(Selectors.byId("customer.password")); // <-- добавлено
    private SelenideElement repeatedPasswordInput = element(Selectors.byId("repeatedPassword")); // <-- добавлено

    private SelenideElement registerButton = element(Selectors.byValue("Register"));

    //Поля ошибок
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
    public void open(){
        Selenide.open("/parabank/register.htm");
    }

    public void register(BankAccount bankAccount) {
        if (bankAccount.getFirstName() != null) {
            firstNameInput.sendKeys(bankAccount.getFirstName());
        }
        if (bankAccount.getLastName() != null) {
            lastNameInput.sendKeys(bankAccount.getLastName());
        }
        if (bankAccount.getAddress() != null) {
            addressInput.sendKeys(bankAccount.getAddress());
        }
        if (bankAccount.getCity() != null) {
            cityInput.sendKeys(bankAccount.getCity());
        }
        if (bankAccount.getState() != null) {
            stateInput.sendKeys(bankAccount.getState());
        }
        if (bankAccount.getZipCode() != null) {
            zipCodeInput.sendKeys(bankAccount.getZipCode());
        }
        if (bankAccount.getPhoneNumber() != null) {
            phoneNumberInput.sendKeys(bankAccount.getPhoneNumber());
        }
        if (bankAccount.getSsn() != null) {
            ssnInput.sendKeys(bankAccount.getSsn());
        }
        if (bankAccount.getUsername() != null) {
            usernameInput.sendKeys(bankAccount.getUsername());
        }
        if (bankAccount.getPassword() != null) {
            passwordInput.sendKeys(bankAccount.getPassword());
        }
        if (bankAccount.getPasswordConfirmation() != null) {
            repeatedPasswordInput.sendKeys(bankAccount.getPasswordConfirmation());
        }

        registerButton.click();
    }

}
