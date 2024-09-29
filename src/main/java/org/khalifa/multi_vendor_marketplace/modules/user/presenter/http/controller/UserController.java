package org.khalifa.multi_vendor_marketplace.modules.user.presenter.http.controller;

import jakarta.validation.Valid;
import org.khalifa.multi_vendor_marketplace.modules.user.application.UserService;
import org.khalifa.multi_vendor_marketplace.modules.user.domain.User;
import org.khalifa.multi_vendor_marketplace.modules.user.presenter.http.controller.dto.CreateUserDTO;
import org.khalifa.multi_vendor_marketplace.modules.user.presenter.http.controller.dto.EchoInputDTO;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@SchemaMapping(typeName = "User")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @MutationMapping()
    public String echo(@Valid @Argument EchoInputDTO payload) {
        return payload.message();
    }

    @MutationMapping("userCreate")
    public User createUser(@Valid @Argument CreateUserDTO input) {
        return userService.createUser(input);
    }

    @QueryMapping
    public String hello() {
        return "Hello Graphql World!";
    }

    @QueryMapping("userFindAll")
    public List<User> findAll() {
        return this.userService.findAll();
    }
}
