package org.example;

import com.codeborne.selenide.*;
import org.example.ui.pages.RegisterAccountPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.element;

public class SimpleUITest {
    @BeforeAll
    public static void setupUiTests(){
        Configuration.baseUrl = "https://parabank.parasoft.com";
        //Configuration.browser = "firefox";
        //Configuration.timeout = 10;

        // ПРИНЦИПЫ
        // DRY = Dont Repeat Yourself
        // Веб элементы НЕ ИШУТСЯ в тесте, они ищутся в PAGE OBJECT классе

    }

    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly(){
        //Подготовка
        //Selenide.open("/parabank/register.htm");
        // Создаем новую страничку
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();

        registerAccountPage.open();

        registerAccountPage.register("Саша", "Git");

        //Шаги теста: Имя
        //SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        //firstName.sendKeys("Саша");

        //Шаги теста: Фамилия
        //SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        //lastName.sendKeys("Пше");

        //Шаги теста: Кнопка регистрации
        //SelenideElement registerButton = element(Selectors.byValue("Register"));
        //registerButton.click();

        //Проверка ожидаемого результата: Адрес
        //SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getAddressError().shouldHave(Condition.cssClass("error"));

        // Проверка ожидаемого результата: Город
        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getCityError().shouldHave(Condition.cssClass("error"));

        // Проверка ожидаемого результата: Область
        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getStateError().shouldHave(Condition.cssClass("error"));

        // Проверка ожидаемого результата: Почтовый индекс
        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getZipCodeError().shouldHave(Condition.cssClass("error"));

        // Возможно, проверка телефона избыточная
        // Телефон, элемент показан на странице
        registerAccountPage.getPhoneNumber().shouldBe(Condition.visible);

        // Телефон, элемент присуствует на странице
        registerAccountPage.getPhoneNumber1().shouldBe(Condition.exist);

        // Проверка ожидаемого результата: Номер страхования
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.cssClass("error"));

        // Проверка ожидаемого результата: Юзернейм
        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getUsernameError().shouldHave(Condition.cssClass("error"));

        // Проверка ожидаемого результата: Пароль
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.cssClass("error"));

        // Проверка ожидаемого результата: Подтверждение пароля
        registerAccountPage.getPasswordConfirmationError().shouldHave(Condition.exactText("Password confirmation is required."));
        registerAccountPage.getPasswordConfirmationError().shouldHave(Condition.cssClass("error"));
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
