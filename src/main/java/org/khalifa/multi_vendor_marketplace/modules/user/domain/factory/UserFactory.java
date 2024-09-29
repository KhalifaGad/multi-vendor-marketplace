package org.khalifa.multi_vendor_marketplace.modules.user.domain.factory;

import org.khalifa.multi_vendor_marketplace.modules.user.domain.User;

import java.util.UUID;

public class UserFactory {
    private UserFactory() {
    }

    public static User create(NewUserFactoryParams params) {
        UUID id = UUID.randomUUID();
        return new User(id, params.firstName(), params.lastName(), params.email(), params.phone(), params.dateOfBirth());
    }

    public static User create(ExistingUserFactoryParams params) {
        return new User(params.id(), params.firstName(), params.lastName(), params.email(), params.phone(), params.dateOfBirth());
    }
}
