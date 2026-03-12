package by.pirog.project_for_devops.core.repository;

import by.pirog.project_for_devops.core.model.UserEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Logger LOG = LogManager.getLogger(UserRepository.class);

    default Optional<UserEntity> findByIdWithLog(Long id) {
        LOG.info("БД: запрос пользователя по id={}", id);
        var result = findById(id);
        if (result.isPresent()) {
            LOG.info("БД: пользователь найден по id={}", id);
        } else {
            LOG.warn("БД: пользователь не найден по id={}", id);
        }
        return result;
    }

    default UserEntity saveWithLog(UserEntity entity) {
        LOG.info("БД: сохранение пользователя userName={}, email={}", entity.getUserName(), entity.getEmail());
        var saved = save(entity);
        LOG.info("БД: пользователь успешно сохранен с id={}", saved.getId());
        return saved;
    }
}
