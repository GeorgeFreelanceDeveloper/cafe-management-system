package com.example.cafemanagementsystem.model.dto;

import jakarta.validation.constraints.NotNull;

public record BillDto(
        Integer id,
        String uuid,
        @NotNull(message = "Name cannot be null") String name,
        @NotNull(message = "Email cannot be null") String email,
        @NotNull(message = "ContactNumber cannot be null") String contactNumber,
        @NotNull(message = "PaymentMethod cannot be null") String paymentMethod,
        @NotNull(message = "Total cannot be null") Integer total,
        @NotNull(message = "ProductDetail cannot be null") String productDetail,
        String createdBy

) {
}
