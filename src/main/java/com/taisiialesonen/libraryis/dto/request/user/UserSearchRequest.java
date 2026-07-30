package com.taisiialesonen.libraryis.dto.request.user;

import com.taisiialesonen.libraryis.enums.RoleEnum;
import com.taisiialesonen.libraryis.enums.StatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Поисковой фильтр")
public class UserSearchRequest {

    @Schema(description = "Поисковый запрос")
    private String search;

    @Schema(description = "Фильтр по роли")
    private RoleEnum role;

    @Schema(description = "Фильтр по статусу")
    private StatusEnum status;

    @Schema(description = "Номер страницы")
    private int page;

    @Schema(description = "Размер страницы")
    private int size;

    @Schema(description = "Сортировка")
    private String sort;
}
