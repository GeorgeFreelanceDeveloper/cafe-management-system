package com.example.cafemanagementsystem.model.dto;

public record ReportItemDto(
        Integer id,
        String name,
        String category,
        Integer quantity,
        Double price,
        Double total
) {
}
