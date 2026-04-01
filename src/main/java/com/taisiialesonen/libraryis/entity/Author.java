package com.taisiialesonen.libraryis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "authors")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author extends AuditableEntity {

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "patronymic")
    String patronymic;

    @Column(name = "biography", columnDefinition = "TEXT")
    String biography;

    @Column(name = "birth_date")
    LocalDate birthDate;

    @Column(name = "death_date")
    LocalDate deathDate;

    @Column(name = "nationality")
    String nationality;

    @Column(name = "photo_url")
    String photoUrl;
}
