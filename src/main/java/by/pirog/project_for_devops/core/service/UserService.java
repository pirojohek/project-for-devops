package by.pirog.project_for_devops.core.service;

import by.pirog.project_for_devops.api.dto.UserRequestDto;
import by.pirog.project_for_devops.core.model.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity getById(Long id);

    UserEntity create(UserRequestDto request);

    List<UserEntity> getUsers();
}
