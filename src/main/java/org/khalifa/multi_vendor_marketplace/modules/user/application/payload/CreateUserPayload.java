package org.khalifa.multi_vendor_marketplace.modules.user.application.payload;

import java.time.LocalDate;

public interface CreateUserPayload {
    String firstName();

    String lastName();

    String email();

    String phone();

    LocalDate dateOfBirth();
}
