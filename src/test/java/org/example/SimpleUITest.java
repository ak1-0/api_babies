package org.example;

import com.codeborne.selenide.*;
import org.example.ui.pages.RegisterAccountPage;
import org.example.ui.pages.datas.BankAccount;
import org.example.utils.RandomData;
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
        // Веб элементы НЕ ИЩУТСЯ в тесте, они ищутся в PAGE OBJECT классе
        // АВТОТЕСТ САМ СОЗДАЕТ РАНДОМИЗИРОВАННЫЕ ДАННЫЕ

    }

    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly(){
        //Подготовка страницы
        // Создаем новую страничку
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        //Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .build();

        registerAccountPage.register(bankAccount);

        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getAddressError().shouldHave(Condition.cssClass("error"));

        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getCityError().shouldHave(Condition.cssClass("error"));

        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getStateError().shouldHave(Condition.cssClass("error"));

        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getZipCodeError().shouldHave(Condition.cssClass("error"));

        registerAccountPage.getPhoneNumber().shouldBe(Condition.visible);
        registerAccountPage.getPhoneNumber1().shouldBe(Condition.exist);

        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.cssClass("error"));

        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getUsernameError().shouldHave(Condition.cssClass("error"));

        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.cssClass("error"));

        registerAccountPage.getPasswordConfirmationError().shouldHave(Condition.exactText("Password confirmation is required."));
        registerAccountPage.getPasswordConfirmationError().shouldHave(Condition.cssClass("error"));
    }

    @Test
    public void userCanCreateAccountWithValidData() {
        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .address(RandomData.randomString())
                .city(RandomData.randomString())
                .state(RandomData.randomString())
                .zipCode(RandomData.randomNumericString(5))
                .phoneNumber(RandomData.randomNumericString(10))
                .ssn(RandomData.randomNumericString(9))
                .username(RandomData.randomString())
                .password("password123")
                .passwordConfirmation("password123")
                .build();

        // Создание страницы регистрации
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        // Регистрация пользователя с использованием случайных данных
        registerAccountPage.register(bankAccount);

        // Шаги теста: Проверка успешной регистрации
        // Проверка успешной регистрации
        SelenideElement successMessage = element(Selectors.byCssSelector("#rightPanel p"));
        successMessage.shouldHave(Condition.text("Your account was created successfully. You are now logged in."));
    }
}
