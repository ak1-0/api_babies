package org.example.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.api.models.Student;

public class JsonMapper {

    // Метод для маппинга объекта Student в JSON
    public static String studentToJson(Student student) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(student);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Ошибка при сериализации объекта Student в JSON", e);
        }
    }

    // Метод для маппинга JSON в объект Student
    public static Student jsonToStudent(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, Student.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Ошибка при десериализации JSON в объект Student", e);
        }
    }
}
