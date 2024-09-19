package org.khalifa.multi_vendor_marketplace.modules.user.user.domain.factory;

import java.time.LocalDate;
import java.util.UUID;

public record ExistingUserFactoryParams(
        UUID id,
        String firstName,
        String lastName,
        String email,
        String phone,
        LocalDate dateOfBirth
) {
}

