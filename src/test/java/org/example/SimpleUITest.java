package org.example;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.channels.Selector;

import static com.codeborne.selenide.Selenide.element;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleUITest {
    @BeforeAll
    public static void setupUiTests(){
        Configuration.baseUrl = "https://parabank.parasoft.com";
        //Configuration.browser = "firefox";
        //Configuration.timeout = 10;

    }

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

    @Test
    public void userCanCreateAccountWithValidData() {
        // Подготовка: Открытие страницы регистрации
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        // Шаги теста: Заполнение всех обязательных полей

        // Имя
        SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("Саша");

        // Фамилия
        SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Пше");

        // Адрес
        SelenideElement address = element(Selectors.byId("customer.address.street"));
        address.sendKeys("Саша");

        // Город
        SelenideElement city = element(Selectors.byId("customer.address.city"));
        city.sendKeys("Саша");

        // Область
        SelenideElement state = element(Selectors.byId("customer.address.state"));
        state.sendKeys("Саша");

        // Почтовый индекс
        SelenideElement zipCode = element(Selectors.byId("customer.address.zipCode"));
        zipCode.sendKeys("Саша");

        // Телефон
        SelenideElement phoneNumber = element(Selectors.byId("customer.phoneNumber"));
        phoneNumber.sendKeys("Саша");

        // Номер социального страхования
        SelenideElement ssn = element(Selectors.byId("customer.ssn"));
        ssn.sendKeys("Саша");

        // Юзернейм
        SelenideElement username = element(Selectors.byId("customer.username"));
        username.sendKeys("Саша11");

        // Пароль
        SelenideElement password = element(Selectors.byId("customer.password"));
        password.sendKeys("Саша11");

        // Подтверждение пароля
        SelenideElement repeatedPassword = element(Selectors.byId("repeatedPassword"));
        repeatedPassword.sendKeys("Саша11");

        // Шаги теста: Кнопка регистрации
        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        // Шаги теста: Проверка успешной регистрации

        // Проверка, что после успешной регистрации пользователь перенаправлен на страницу с подтверждением
        SelenideElement successMessage = element(Selectors.byCssSelector("#rightPanel p"));
        successMessage.shouldHave(Condition.text("Your account was created successfully. You are now logged in."));

        // Дополнительная проверка: проверка успешного перехода на страницу с логином
        //SelenideElement loginLink = element(Selectors.byLinkText(""));
        //loginLink.shouldBe(Condition.visible);
    }


}
