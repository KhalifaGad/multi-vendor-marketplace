package org.khalifa.multi_vendor_marketplace.modules.user.infrastructure.persistence.postgres.repository;

import org.khalifa.multi_vendor_marketplace.modules.user.infrastructure.persistence.postgres.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {
}
