package com.taisiialesonen.libraryis.dto.request.user;

import com.taisiialesonen.libraryis.enums.StatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Изменение статуса")
public class ChangeStatusRequest {

    @NotNull
    @Schema(description = "Статус")
    private StatusEnum status;
}
