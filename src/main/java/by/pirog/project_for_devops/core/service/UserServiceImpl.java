package by.pirog.project_for_devops.core.service;

import by.pirog.project_for_devops.core.model.UserEntity;
import by.pirog.project_for_devops.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    @Cacheable(value = "user:byId", key = "#id", sync = true)
    public UserEntity getById(Long id) {
        log.info("Сервис: поиск пользователя по id={}", id);
        return userRepository.findByIdWithLog(id)
                .orElseThrow(() -> {
                    log.warn("Сервис: пользователь не найден по id={}", id);
                    return new RuntimeException("Пользователь не найден. id=" + id);
                });
    }

    @Override
    public UserEntity create(UserEntity userEntity) {
        log.info("Сервис: создание пользователя userName={}, email={}", userEntity.getUserName(), userEntity.getEmail());
        userEntity.setId(null);
        var savedUser = this.userRepository.saveWithLog(userEntity);
        log.info("Сервис: пользователь сохранен в БД с id={}", savedUser.getId());
        return savedUser;
    }
}
