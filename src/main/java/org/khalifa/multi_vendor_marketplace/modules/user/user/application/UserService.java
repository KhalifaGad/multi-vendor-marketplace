package org.khalifa.multi_vendor_marketplace.modules.user.user.application;

import org.khalifa.multi_vendor_marketplace.modules.user.user.application.portal.UserRepository;
import org.khalifa.multi_vendor_marketplace.modules.user.user.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String hello() {
        return "Hello Graphql World! from UserService";
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
