package org.example.api.models;

import com.google.gson.annotations.SerializedName;

public class Student {
    private String name;
    private int grade;
    @SerializedName("_id")
    private String id;

    // Конструктор с параметрами
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public String getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

}
