package com.home.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AnimalCreateDto {
    @NotNull
    @Size(min = 3,max = 20)
    private String name;

    @NotNull
    @Max(100)
    @Min((3))
    private Integer age;

    @NotNull
    @Size(min = 3,max = 50)
    private String place;
}
