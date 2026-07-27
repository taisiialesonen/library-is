package com.taisiialesonen.libraryis.repository;

import com.taisiialesonen.libraryis.entity.User;
import com.taisiialesonen.libraryis.enums.RoleEnum;
import com.taisiialesonen.libraryis.enums.StatusEnum;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

/**
 * Фабрика спецификаций для динамической фильтрации пользователей.
 */
public class UserSpecification {

    private UserSpecification() {}

    /**
     * Фильтр по роли.
     *
     * @param role роль пользователя (может быть null)
     * @return спецификация для фильтрации по роли
     */
    public static Specification<User> byRole(RoleEnum role) {
        return (root, query, criteriaBuilder) -> {
            if (role == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("role"), role);
        };
    }

    /**
     * Фильтр по статусу.
     *
     * @param status статус пользователя (может быть null)
     * @return спецификация для фильтрации по статусу
     */
    public static Specification<User> byStatus(StatusEnum status) {
        return (root, query, criteriaBuilder) -> {
            if (status == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("status"), status);
        };
    }

    /**
     * Поиск по тексту в полях: username, email, firstName, lastName.
     *
     * @param searchQuery поисковый запрос (может быть null или пустым)
     * @return спецификация для поиска
     */
    public static Specification<User> bySearchQuery(String searchQuery) {
        return (root, query, criteriaBuilder) -> {
            if (!StringUtils.hasText(searchQuery)) {
                return criteriaBuilder.conjunction();
            }
            String pattern = "%" + searchQuery.toLowerCase() + "%";
            Predicate usernamePredicate = criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("username")), pattern);
            Predicate emailPredicate = criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("email")), pattern);
            Predicate firstNamePredicate = criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("firstName")), pattern);
            Predicate lastNamePredicate = criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("lastName")), pattern);
            return criteriaBuilder.or(
                    usernamePredicate,
                    emailPredicate,
                    firstNamePredicate,
                    lastNamePredicate
            );
        };
    }
}
