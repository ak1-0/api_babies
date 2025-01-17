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
    }

    @Test
    public void userShouldBeAbleCreateStudent() {
        // Создаем объект студента
        Student student = Student.builder()
                .name("Саша Петров")
                .grade(2)
                .build();

        // Создаем студента с использованием маппинга
        StudentRequests.createStudent(student);
    }

    @Test
    public void userShouldBeAbleDeleteExistingStudent() {
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
}
