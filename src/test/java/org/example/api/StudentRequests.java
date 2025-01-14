package org.example.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.example.api.models.Student;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class StudentRequests {
    // Метод для создания студента
    public static Student createStudent(Student student) {
        String studentJson = null;
        try {
            // Создаем экземпляр ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();
            studentJson = objectMapper.writeValueAsString(student);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        // Отправляем запрос на создание студента
        return given()
                .body(studentJson)
                .contentType(ContentType.JSON)
                .when()
                .post("/student/")
                .then()
                .assertThat()
                .statusCode(201)
                .body("$", hasKey("_id"))
                .extract().as(Student.class, ObjectMapperType.GSON);
    }

    // Метод для удаления студента
    public static void deleteStudent(String id) {
        given()
                .delete("student/" + id)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
