package com.taisiialesonen.libraryis.dto.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(description = "Данные, которые могут быть изменены пользователем")
public class UpdateUserRequest {

    @Schema(description = "Имя")
    private String firstName;

    @Schema(description = "Фамилия")
    private String lastName;

    @Schema(description = "Отчество")
    private String patronymic;

    @Schema(description = "Телефон")
    private String phone;

    @Email(message = "Email should be valid")
    @Schema(description = "Почта")
    private String email;

    @Schema(description = "Адрес")
    private String address;

    @Schema(description = "Дата рождения")
    private LocalDate birthDate;
}

