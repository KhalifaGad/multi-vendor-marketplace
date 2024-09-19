package org.khalifa.multi_vendor_marketplace.modules.user.user.infrastructure.persistence.postgres.mapper;

import org.khalifa.multi_vendor_marketplace.modules.user.user.domain.User;
import org.khalifa.multi_vendor_marketplace.modules.user.user.infrastructure.persistence.postgres.entity.UserEntity;

public class UserMapper {
    private UserMapper() {
    }
    
    public static UserEntity toEntity(User user) {
        return new UserEntity(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhone(),
                user.getDateOfBirth()
        );
    }

    public static User toDomain(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail(),
                userEntity.getPhone(),
                userEntity.getDateOfBirth()
        );
    }
}
