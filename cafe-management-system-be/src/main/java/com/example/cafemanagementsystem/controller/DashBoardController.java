package com.example.cafemanagementsystem.controller;

import com.example.cafemanagementsystem.service.DashboardService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/dashboard")
public class DashBoardController {

    private final DashboardService dashboardService;

    @Autowired
    public DashBoardController(@NotNull final DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/details")
    @Operation(summary = "Get count products, categories and bills")
    ResponseEntity<Map<String, Object>> getCount() {
        return dashboardService.getCount();
    }
}
