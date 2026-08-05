package com.taisiialesonen.libraryis.dto.response.user;

import com.taisiialesonen.libraryis.enums.RoleEnum;
import com.taisiialesonen.libraryis.enums.StatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Schema(description = "Краткое описание пользователя")
public class UserSummaryResponse {

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
}
