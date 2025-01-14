package org.example.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;

import lombok.*;

@Data
//@AllArgsConstructor
@Builder
//@ToString
//@Setter
//@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {
    private String name;
    private int grade;
    @SerializedName("_id")
    private String id;

}
