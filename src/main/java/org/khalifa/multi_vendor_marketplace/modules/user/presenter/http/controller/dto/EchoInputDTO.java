package org.khalifa.multi_vendor_marketplace.modules.user.presenter.http.controller.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EchoInputDTO(
        @NotNull
        @Size(min = 2, max = 2)
        String message
) {
}
