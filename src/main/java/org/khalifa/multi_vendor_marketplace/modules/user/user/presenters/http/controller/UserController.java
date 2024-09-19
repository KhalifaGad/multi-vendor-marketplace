package org.khalifa.multi_vendor_marketplace.modules.user.user.presenters.http.controller;

import jakarta.validation.Valid;
import org.khalifa.multi_vendor_marketplace.modules.user.user.application.UserService;
import org.khalifa.multi_vendor_marketplace.modules.user.user.domain.User;
import org.khalifa.multi_vendor_marketplace.modules.user.user.presenters.http.controller.dto.CreateUserDTO;
import org.khalifa.multi_vendor_marketplace.modules.user.user.presenters.http.controller.dto.EchoInputDTO;
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
    public String createUser(@Valid @Argument CreateUserDTO input) {
        System.out.println(input.firstName());
        System.out.println(input.lastName());
        System.out.println(input.email());
        System.out.println(input.phone());
        System.out.println(input.dateOfBirth());
        return "Valid User";
    }

    @QueryMapping
    public String hello() {
        return "Hello Graphql World!";
    }

    @QueryMapping("userHello")
    public String helloUser() {
        return this.userService.hello();
    }

    @QueryMapping("userFindAll")
    public List<User> findAll() {
        return this.userService.findAll();
    }
}
