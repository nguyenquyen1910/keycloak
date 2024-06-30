package com.devteria.profile.controller;

import com.devteria.profile.dto.ApiResponse;
import com.devteria.profile.dto.response.UserResponse;
import com.devteria.profile.service.ProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profiles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ProfileController {
    ProfileService profileService;

    @GetMapping
    ApiResponse<List<UserResponse>> getAllProfiles() {
        return ApiResponse.<List<UserResponse>>builder()
                .result(profileService.getAllProfiles())
                .build();
    }
}
