package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.internal.RestAssuredResponseOptionsGroovyImpl;
import org.apache.http.HttpStatus;
import org.example.api.StudentRequests;
import org.example.api.models.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.hasKey;

public class SimpleTest {
    @BeforeAll
    public static void setupTests(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/d455de6fe2354674841491bcc4778825";

    }


    @Test
    public void userShouldBeAdleCreateStudent(){
        // given - when - then BDD подход
        //StudentRequests studentRequests = new StudentRequests();

        // серилизация из JSON в объект и наоборот
        Student student = new Student("Саша Петров", 2);
        StudentRequests.createStudent(student);
    }

    @Test
    public void userShouldBeAbleDeleteExistingStudent() {
        // ПРИНЦИПЫ РАЗРАБОТКИ API ТЕСТОВ
        // 1. АТОМАРНОСТЬ
        // 2. ТЕСТ САМ СЕБЕ ГОТОВИТ ДАННЫЕ

        // FAIL FIRST

        // ШАГ 1: СОЗДАНИЕ СТУДЕНТА
        Student student = new Student("Саша Петров", 2);
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
