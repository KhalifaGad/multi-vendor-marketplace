package org.khalifa.multi_vendor_marketplace.modules.user.infrastructure.persistence.postgres.mapper;

import org.khalifa.multi_vendor_marketplace.modules.user.domain.User;
import org.khalifa.multi_vendor_marketplace.modules.user.domain.factory.ExistingUserFactoryParams;
import org.khalifa.multi_vendor_marketplace.modules.user.domain.factory.UserFactory;
import org.khalifa.multi_vendor_marketplace.modules.user.infrastructure.persistence.postgres.entity.UserEntity;

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
        return UserFactory.create(new ExistingUserFactoryParams(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail(),
                userEntity.getPhone(),
                userEntity.getDateOfBirth()
        ));
    }
}
