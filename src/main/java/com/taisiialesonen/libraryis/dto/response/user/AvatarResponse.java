package com.taisiialesonen.libraryis.dto.response.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "URL аватарки")
public class AvatarResponse {

    @Schema(description = "URL аватарки")
    private String avatarUrl;
}
