package com.example.cafemanagementsystem.model.dto;


public record UserDto(
        Integer id,
        String name,
        String email,
        String contactNumber,
        String status
) {
}
