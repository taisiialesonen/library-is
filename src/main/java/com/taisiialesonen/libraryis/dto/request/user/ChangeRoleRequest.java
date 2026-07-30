package com.taisiialesonen.libraryis.dto.request.user;

import com.taisiialesonen.libraryis.enums.RoleEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Изменение роли")
public class ChangeRoleRequest {

    @NotNull
    @Schema(description = "Роль")
    private RoleEnum role;
}
