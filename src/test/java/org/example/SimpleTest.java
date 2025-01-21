package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.example.api.StudentRequests;
import org.example.api.models.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SimpleTest {

    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/7997a746d87e40c780245a271544323f";
        //Спецификация запроса
        //сюда передаем все значения, которые хотим по умолчанию передавать в хедерах в каждом запросе
        //RestAssured.requestSpecification = new RequestSpecification().contentType().
        //Так же и response (стстус код, accept type

        //Принцип программирования DRY
    }

    @Test
    public void userShouldBeAbleCreateStudent() {
        // given-when-then BDD
        // серилизация из объект в JSON и наоборот

        Student student = Student.builder()
                .name("Саша Петров")
                .grade(2)
                .build();

        // Создаем студента с использованием маппинга
        StudentRequests.createStudent(student);
    }

    @Test
    public void userShouldBeAbleDeleteExistingStudent() {
        // Принцип разработки API тестов
        // Атомарность
        // Тест сам себе готовит данные
        // Fail First
        // Создаем объект студента
        Student student = Student.builder()
                .name("Саша Петров")
                .grade(2)
                .build();

        // ШАГ 1: СОЗДАНИЕ СТУДЕНТА
        Student createdStudent = StudentRequests.createStudent(student);

        // ШАГ 2: УДАЛЕНИЕ СТУДЕНТА
        StudentRequests.deleteStudent(createdStudent.getId());

        // ШАГ 3: ПРОВЕРКА, ЧТО СТУДЕНТ НЕ СУЩЕСТВУЕТ
        given()
                .get("student/" + createdStudent.getId())
                .then()
                .assertThat()
                .statusCode(404);
    }
    // покрытие эндпоинтов
    // 1. Позитивный сценарий
    // 2. Покрытие всех статус кодов из api документации или swagger
    // 3. Покрыты все граничные значения и классы эквивалентности параметров запроса (всех негативных сценариев)
}
