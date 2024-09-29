package org.khalifa.multi_vendor_marketplace.modules.user.application.portal;

import org.khalifa.multi_vendor_marketplace.modules.user.domain.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    List<User> findAll();
}
