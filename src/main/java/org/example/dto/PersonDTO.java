package org.example.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record PersonDTO(
        @NotBlank(message = "Name is required") String name,
        @Min(value = 0, message = "Age must be non-negative") int age
) {}