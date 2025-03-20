package org.example.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

// In Java 14, Records are immutable data classes that require only the type and name of fields.
public record PersonDTO(
        @NotBlank(message = "Name is required") String name,
        @Min(value = 0, message = "Age must be non-negative") int age
) {}