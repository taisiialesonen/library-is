package com.taisiialesonen.libraryis.repository;

import com.taisiialesonen.libraryis.entity.User;
import com.taisiialesonen.libraryis.enums.RoleEnum;
import com.taisiialesonen.libraryis.enums.StatusEnum;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;


public interface UserRepository extends JpaRepository<User, UUID>, JpaSpecificationExecutor<User> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    Page<User> findAllByStatus(StatusEnum status, Pageable pageable);

    Page<User> findAllByRole(RoleEnum role, Pageable pageable);

    Long countByStatus(StatusEnum status);

    Long countByRole(RoleEnum role);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.lastLoginAt = :lastLoginAt WHERE u.id = :id")
    void updateLastLoginAt(@Param("id") UUID userId, @Param("lastLoginAt") OffsetDateTime lastLoginAt);
//    List<User> finadActiveReadersWithBorrowings(); TODO: Требуется таблица

}
