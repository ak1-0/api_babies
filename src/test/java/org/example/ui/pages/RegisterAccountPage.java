package org.example.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.example.ui.pages.datas.BankAccount;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.element;

@Getter
public class RegisterAccountPage {
    private SelenideElement firstNameInput = element(Selectors.byId("customer.firstName"));
    private SelenideElement lastNameInput = element(Selectors.byId("customer.lastName"));

    //добавить все важные элементы веб-странички В ПОЛЯ
    private SelenideElement addressInput = element(Selectors.byId("customer.address.street"));
    private SelenideElement cityInput = element(Selectors.byId("customer.address.city"));
    private SelenideElement stateInput = element(Selectors.byId("customer.address.state"));
    private SelenideElement zipCodeInput = element(Selectors.byId("customer.address.zipCode"));
    private SelenideElement phoneNumberInput = element(Selectors.byId("customer.phoneNumber"));
    private SelenideElement ssnInput = element(Selectors.byId("customer.ssn"));
    private SelenideElement usernameInput = element(Selectors.byId("customer.username"));
    private SelenideElement passwordInput = element(Selectors.byId("customer.password"));
    private SelenideElement repeatedPasswordInput = element(Selectors.byId("repeatedPassword"));

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

    public void open() {
        Selenide.open("/parabank/register.htm");
    }

    public void register(BankAccount bankAccount) {
        List<Runnable> actions = List.of(
                () -> fillInput(bankAccount.getFirstName(), firstNameInput),
                () -> fillInput(bankAccount.getLastName(), lastNameInput),
                () -> fillInput(bankAccount.getAddress(), addressInput),
                () -> fillInput(bankAccount.getCity(), cityInput),
                () -> fillInput(bankAccount.getState(), stateInput),
                () -> fillInput(bankAccount.getZipCode(), zipCodeInput),
                () -> fillInput(bankAccount.getPhoneNumber(), phoneNumberInput),
                () -> fillInput(bankAccount.getSsn(), ssnInput),
                () -> fillInput(bankAccount.getUsername(), usernameInput),
                () -> fillInput(bankAccount.getPassword(), passwordInput),
                () -> fillInput(bankAccount.getPasswordConfirmation(), repeatedPasswordInput)
        );

        actions.forEach(Runnable::run);

        registerButton.click();
    }

    private void fillInput(String value, SelenideElement input) {
        if (value != null) {
            input.sendKeys(value);
        }

    }
}
