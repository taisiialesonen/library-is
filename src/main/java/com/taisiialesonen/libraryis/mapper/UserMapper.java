package com.taisiialesonen.libraryis.mapper;

import com.taisiialesonen.libraryis.dto.request.user.CreateUserRequest;
import com.taisiialesonen.libraryis.dto.request.user.RegisterRequest;
import com.taisiialesonen.libraryis.dto.request.user.UpdateUserRequest;
import com.taisiialesonen.libraryis.dto.response.user.UserDetailResponse;
import com.taisiialesonen.libraryis.dto.response.user.UserSummaryResponse;
import com.taisiialesonen.libraryis.entity.User;
import org.mapstruct.*;

import java.net.CacheRequest;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target ="id",ignore = true)
    @Mapping(target ="passwordHash",ignore = true)
    @Mapping(target ="createdAt",ignore = true)
    @Mapping(target ="updatedAt",ignore = true)
    @Mapping(target ="role",ignore = true)
    @Mapping(target ="status",ignore = true)
    User toUser(RegisterRequest request);

    @Mapping(target ="id",ignore = true)
    @Mapping(target ="passwordHash",ignore = true)
    @Mapping(target ="createdAt",ignore = true)
    @Mapping(target ="updatedAt",ignore = true)
    @Mapping(target ="status",ignore = true)
    User toUser(CreateUserRequest request);

    UserSummaryResponse toSummaryResponse(User user);

    UserDetailResponse toDetailResponse(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target ="id",ignore = true)
    @Mapping(target ="passwordHash",ignore = true)
    @Mapping(target ="createdAt",ignore = true)
    @Mapping(target ="updatedAt",ignore = true)
    @Mapping(target ="role",ignore = true)
    @Mapping(target ="status",ignore = true)
    void updateUserFromRequest(
            UpdateUserRequest request,
            @MappingTarget User user
    );
    List<UserSummaryResponse> toSummaryList(List<User> user);
}
