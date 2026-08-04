package com.taisiialesonen.libraryis.dto.response.user;

import com.taisiialesonen.libraryis.enums.RoleEnum;
import com.taisiialesonen.libraryis.enums.StatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Schema(description = "Полный профиль пользователя")
public class UserProfileResponse {
    @Schema(description = "ID пользователя")
    private UUID id;

    @Schema(description = "Логин")
    private String username;

    @Schema(description = "Почта")
    private String email;

    @Schema(description = "Имя")
    private String firstName;

    @Schema(description = "Фамилия")
    private String  lastName;

    @Schema(description = "Отчество")
    private String patronymic;

    @Schema(description = "Телефон")
    private String phone;

    @Schema(description = "Роль")
    private RoleEnum role;

    @Schema(description = "URL Аватарки")
    private String avatarUrl;

    @Schema(description = "Статус")
    private StatusEnum status;

    @Schema(description = "Дата регистрации")
    private LocalDateTime registrationData;

    @Schema(description = "Адрес")
    private String address;

    @Schema(description = "Дата рождения")
    private LocalDate birthDate;

    @Schema(description = "Дата последнего входа")
    private LocalDateTime lastLoinAt;

    @Schema(description = "Дата создания")
    private LocalDateTime createdAt;

    @Schema(description = "Дата обновления")
    private LocalDateTime updatedAt;

    @Schema(description = "Количество книг у пользователя")
    private int activeBorrowingsCount;

    @Schema(description = "Сумма штрафов")
    private BigDecimal pendingFinesAmount;
}
