package org.khalifa.multi_vendor_marketplace.modules.user.application;

import org.khalifa.multi_vendor_marketplace.modules.user.application.payload.CreateUserPayload;
import org.khalifa.multi_vendor_marketplace.modules.user.application.portal.UserRepository;
import org.khalifa.multi_vendor_marketplace.modules.user.domain.User;
import org.khalifa.multi_vendor_marketplace.modules.user.domain.factory.NewUserFactoryParams;
import org.khalifa.multi_vendor_marketplace.modules.user.domain.factory.UserFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User createUser(CreateUserPayload payload) {
        var newUser = UserFactory.create(
                new NewUserFactoryParams(
                        payload.firstName(),
                        payload.lastName(),
                        payload.email(),
                        payload.phone(),
                        payload.dateOfBirth()
                )
        );
        return userRepository.save(newUser);
    }
}
