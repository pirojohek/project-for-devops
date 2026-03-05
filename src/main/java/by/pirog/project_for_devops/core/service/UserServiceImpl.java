package by.pirog.project_for_devops.core.service;

import by.pirog.project_for_devops.core.model.UserEntity;
import by.pirog.project_for_devops.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    @Cacheable(value = "user:byId", key = "#id", sync = true)
    public UserEntity getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Пользователь не найден"));
    }

    @Override
    public UserEntity create(UserEntity userEntity) {
        userEntity.setId(null);
        this.userRepository.save(userEntity);
        return userEntity;
    }
}
