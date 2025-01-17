package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.nio.channels.Selector;

import static com.codeborne.selenide.Selenide.element;

public class SimpleUITest {
    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly(){
        //Подготовка
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        //Шаги теста: Имя
        SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("Саша");

        //Шаги теста: Фамилия
        SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Пше");

        //Шаги теста: Кнопка регистрации
        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();
        //Шаги теста: Имя

        //Проверка ожидаемого результата: Адрес
        SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));
        addressError.shouldHave(Condition.exactText("Address is required."));

        //Город: City is required. ("customer.address.city.errors") ("City is required.")
        //Область: State is required. ("customer.address.state.errors") ("State is required.")
        //Почтовый индекс: Zip Code is required. ("customer.address.zipCode.errors") ("Zip Code is required.")
        //Телефон: ("customer.phoneNumber") ("")
        //Номер страхования: Social Security Number is required. ("customer.ssn.errors") ("Social Security Number is required.")
        //Юзернейм: Username is required. ("customer.username.errors") ("Username is required.)
        //Пароль: Password is required. ("customer.password.errors") ("Password is required.")
        //Подтверждение пароля: Password confirmation is required. ("repeatedPassword.errors") ("Password confirmation is required.")

        // Проверка ожидаемого результата: Город
        SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));
        cityError.shouldHave(Condition.exactText("City is required."));

        // Проверка ожидаемого результата: Область
        SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));
        stateError.shouldHave(Condition.exactText("State is required."));

        // Проверка ожидаемого результата: Почтовый индекс
        SelenideElement zipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));
        zipCodeError.shouldHave(Condition.exactText("Zip Code is required."));

        // Возможно, проверка телефона избыточная
        // Телефон, элемент показан на странице
        SelenideElement phoneNumber = element(Selectors.byId("customer.phoneNumber"));
        phoneNumber.shouldBe(Condition.visible);

        // Телефон, элемент присуствует на странице
        SelenideElement phoneNumber1 = element(Selectors.byId("customer.phoneNumber"));
        phoneNumber1.shouldBe(Condition.exist);

        // Проверка ожидаемого результата: Номер страхования
        SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));
        ssnError.shouldHave(Condition.exactText("Social Security Number is required."));

        // Проверка ожидаемого результата: Юзернейм
        SelenideElement usernameError = element(Selectors.byId("customer.username.errors"));
        usernameError.shouldHave(Condition.exactText("Username is required."));

        // Проверка ожидаемого результата: Пароль
        SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));
        passwordError.shouldHave(Condition.exactText("Password is required."));

        // Проверка ожидаемого результата: Подтверждение пароля
        SelenideElement passwordConfirmationError = element(Selectors.byId("repeatedPassword.errors"));
        passwordConfirmationError.shouldHave(Condition.exactText("Password confirmation is required."));
    }
}
