package org.khalifa.multi_vendor_marketplace.modules.user.domain.factory;

import java.time.LocalDate;

public record NewUserFactoryParams(
        String firstName,
        String lastName,
        String email,
        String phone,
        LocalDate dateOfBirth
) {
}
