package com.taisiialesonen.libraryis.dto.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Новый и старый пароли")
public class ChangePasswordRequest {

    @NotBlank
    @Schema(description = "Новый пароль")
    private String oldPassword;

    @NotBlank
    @Size(min = 8, message = "New password must be at least 8 characters")
    @Schema(description = "Старый пароль")
    private String newPassword;
}
