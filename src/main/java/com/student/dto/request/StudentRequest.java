package com.student.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class StudentRequest {
    @NotBlank(message = "Student name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid email address")
    private String email;

    @NotNull(message = "Age is required")
    @Min(value = 16, message = "Age must be at least 16")
    @Max(value = 60, message = "Age cannot be greater than 60")
    private Integer age;

    @NotBlank(message = "Department is required")
    @Size(min = 2, max = 50, message = "Department must be between 2 and 50 characters")
    private String department;

}
