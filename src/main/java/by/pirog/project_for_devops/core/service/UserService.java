package by.pirog.project_for_devops.core.service;

import by.pirog.project_for_devops.core.model.UserEntity;

public interface UserService {

    UserEntity getById(Long id);

    UserEntity create(UserEntity userEntity);

}
