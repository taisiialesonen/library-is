package com.taisiialesonen.libraryis.entity;

import com.taisiialesonen.libraryis.enums.RoleEnum;
import com.taisiialesonen.libraryis.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@Table(name = "users")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends AuditableEntity {

    @Column(name="username", nullable = false, unique = true)
    String username;

    @Column(name="email", nullable = false, unique = true)
    String email;

    @Column(name="password_hash", nullable = false)
    String passwordHash;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "patronymic")
    String patronymic;

    @Column(name = "phone", nullable = false)
    String phone;

    @Column(name = "avatar_url")
    String avatarUrl;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    RoleEnum role;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    StatusEnum status;

    @Column(name = "address", columnDefinition = "TEXT")
    String address;

    @Column(name = "birth_date")
    LocalDate birthDate;

    @Builder.Default
    @Column(name = "registration_date")
    LocalDate registrationDate = LocalDate.now();

    @Column(name = "last_login_at")
    OffsetDateTime lastLoginAt;
}
