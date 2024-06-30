package com.devteria.profile.mapper;

import com.devteria.profile.dto.request.RegistrationRequest;
import com.devteria.profile.dto.response.UserResponse;
import com.devteria.profile.entity.Profile;
import com.devteria.profile.repository.httpclient.ProfileRepository;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    Profile toProfile(RegistrationRequest request);
    UserResponse toUserResponse(Profile profile);
}
