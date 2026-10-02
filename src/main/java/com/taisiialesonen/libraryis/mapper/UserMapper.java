package com.taisiialesonen.libraryis.mapper;

import com.taisiialesonen.libraryis.dto.request.user.CreateUserRequest;
import com.taisiialesonen.libraryis.dto.request.user.RegisterRequest;
import com.taisiialesonen.libraryis.dto.request.user.UpdateUserRequest;
import com.taisiialesonen.libraryis.dto.response.user.UserDetailResponse;
import com.taisiialesonen.libraryis.dto.response.user.UserSummaryResponse;
import com.taisiialesonen.libraryis.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "avatarUrl", ignore = true)
    @Mapping(target = "lastLoginAt", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    User toUser(RegisterRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "avatarUrl", ignore = true)
    @Mapping(target = "lastLoginAt", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    User toUser(CreateUserRequest request);

    UserSummaryResponse toSummaryResponse(User user);

    @Mapping(target = "lastLoginAt", expression = "java(toLocalDateTime(user.getLastLoginAt()))")
    UserDetailResponse toDetailResponse(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "username", ignore = true)
    @Mapping(target = "avatarUrl", ignore = true)
    @Mapping(target = "lastLoginAt", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    void updateUserFromRequest(
            UpdateUserRequest request,
            @MappingTarget User user
    );

    List<UserSummaryResponse> toSummaryList(List<User> users);

    default LocalDateTime toLocalDateTime(OffsetDateTime value) {
        return value == null ? null : value.toLocalDateTime();
    }
}
