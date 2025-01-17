package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.nio.channels.Selector;

import static com.codeborne.selenide.Selenide.element;
import static org.hamcrest.MatcherAssert.assertThat;

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

        //Проверка ожидаемого результата: Адрес
        SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));
        //addressError.shouldHave(Condition.exactText("Address is required."));
        addressError.shouldHave(Condition.cssClass("error"));

        // Проверка ожидаемого результата: Город
        SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));
        cityError.shouldHave(Condition.exactText("City is required."));
        addressError.shouldHave(Condition.cssClass("error"));

        // Проверка ожидаемого результата: Область
        SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));
        stateError.shouldHave(Condition.exactText("State is required."));
        addressError.shouldHave(Condition.cssClass("error"));

        // Проверка ожидаемого результата: Почтовый индекс
        SelenideElement zipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));
        zipCodeError.shouldHave(Condition.exactText("Zip Code is required."));
        addressError.shouldHave(Condition.cssClass("error"));

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
        addressError.shouldHave(Condition.cssClass("error"));

        // Проверка ожидаемого результата: Юзернейм
        SelenideElement usernameError = element(Selectors.byId("customer.username.errors"));
        usernameError.shouldHave(Condition.exactText("Username is required."));
        addressError.shouldHave(Condition.cssClass("error"));

        // Проверка ожидаемого результата: Пароль
        SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));
        passwordError.shouldHave(Condition.exactText("Password is required."));
        addressError.shouldHave(Condition.cssClass("error"));

        // Проверка ожидаемого результата: Подтверждение пароля
        SelenideElement passwordConfirmationError = element(Selectors.byId("repeatedPassword.errors"));
        passwordConfirmationError.shouldHave(Condition.exactText("Password confirmation is required."));
        addressError.shouldHave(Condition.cssClass("error"));
    }
}
