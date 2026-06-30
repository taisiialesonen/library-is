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


public interface UserRepository extends JpaRepository<User, UUID>, JpaSpecificationExecutor {
    Optional<User> findUserByName(String name);

    Optional<User> FindByEmail(String email);

    Boolean existsByUsername(String name);

    Boolean existsByEmail(String email);

    Optional<User> findByUsernameOrEmail(String name, String email);

    Page<User> findAllByStatus(StatusEnum status, Pageable pageable);

    Page<User> findAllByRole(RoleEnum role, Pageable pageable);

    Long countByStatus(StatusEnum status);

    Long countByRole(RoleEnum role);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.last_login_at=: last_login_at WHERE u.id=: id ")
    void updateLastLoginAt(@Param("id") UUID userId, @Param("last_login_at") OffsetDateTime lastLoginAt);
//    List<User> finadActiveReadersWithBorrowings(); TODO: Требуется таблица

}
