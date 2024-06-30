package com.devteria.profile.service;

import com.devteria.profile.dto.request.RegistrationRequest;
import com.devteria.profile.dto.response.UserResponse;
import com.devteria.profile.mapper.ProfileMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    ProfileService profileService;
    ProfileMapper profileMapper;

    public UserResponse register(RegistrationRequest request){
        var profile = profileService.newProfile(request);
        return profileMapper.toUserResponse(profile);
    }
}
