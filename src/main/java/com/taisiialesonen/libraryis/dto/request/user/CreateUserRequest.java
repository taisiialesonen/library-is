package com.taisiialesonen.libraryis.dto.request.user;

import com.taisiialesonen.libraryis.enums.RoleEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(description = "Данные для создания пользователя")
public class CreateUserRequest {

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Schema(description = "Логин")
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Schema(description = "Почта")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    @Schema(description = "Пароль")
    private String password;

    @NotBlank(message = "First name is required")
    @Schema(description = "Имя")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Schema(description = "Фамилия")
    private String lastName;

    @Schema(description = "Отчество")
    private String patronymic;

    @Schema(description = "Телефон")
    private String phone;

    @Schema(description = "Адрес")
    private String address;

    @Schema(description = "Дата рождения")
    private LocalDate birthDate;

    @NotNull(message = "Role is required")
    @Schema(description = "Роль")
    private RoleEnum role;
}
