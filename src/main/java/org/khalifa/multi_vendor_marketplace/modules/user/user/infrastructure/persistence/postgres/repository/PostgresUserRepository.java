package org.khalifa.multi_vendor_marketplace.modules.user.user.infrastructure.persistence.postgres.repository;

import org.khalifa.multi_vendor_marketplace.modules.user.user.application.portal.UserRepository;
import org.khalifa.multi_vendor_marketplace.modules.user.user.domain.User;
import org.khalifa.multi_vendor_marketplace.modules.user.user.infrastructure.persistence.postgres.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostgresUserRepository implements UserRepository {
    private final JpaUserRepository jpaUserRepository;

    PostgresUserRepository(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    public List<User> findAll() {
        var users = this.jpaUserRepository.findAll();
        return users.stream().map(UserMapper::toDomain).toList();
    }

    public User save(User user) {
        var userEntity = UserMapper.toEntity(user);
        var savedUserEntity = this.jpaUserRepository.save(userEntity);
        return UserMapper.toDomain(savedUserEntity);
    }
}
