package com.devteria.profile.service;

import com.devteria.profile.dto.request.RegistrationRequest;
import com.devteria.profile.dto.response.UserResponse;
import com.devteria.profile.entity.Profile;
import com.devteria.profile.mapper.ProfileMapper;
import com.devteria.profile.repository.httpclient.ProfileRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProfileService {
    ProfileRepository profileRepository;
    ProfileMapper profileMapper;

    public Profile newProfile(RegistrationRequest request){
        var profile = profileMapper.toProfile(request);
        return profileRepository.save(profile);
    }

    public List<UserResponse> getAllProfiles(){
        var profiles = profileRepository.findAll();
        return profiles.stream().map(profileMapper::toUserResponse).toList();
    }
}
