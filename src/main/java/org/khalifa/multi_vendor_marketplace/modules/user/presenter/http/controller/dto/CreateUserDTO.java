package org.khalifa.multi_vendor_marketplace.modules.user.presenter.http.controller.dto;

import jakarta.validation.constraints.*;
import org.khalifa.multi_vendor_marketplace.modules.user.application.payload.CreateUserPayload;

import java.time.LocalDate;

public record CreateUserDTO(
        @NotNull
        @Size(min = 2, max = 50)
        String firstName,

        @NotNull
        @Size(min = 2, max = 50)
        String lastName,

        @NotNull
        @Email
        String email,

        @Pattern(regexp = "^\\+?\\d{10,15}$", message = "Invalid phone number format")
        String phone,

        @NotNull
        @Past
        LocalDate dateOfBirth
) implements CreateUserPayload {
}
