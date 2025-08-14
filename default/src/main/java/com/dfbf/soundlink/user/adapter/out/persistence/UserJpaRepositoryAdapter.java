package com.dfbf.soundlink.user.adapter.out.persistence;

import com.dfbf.soundlink.user.adapter.out.persistence.entity.UserJpaEntity;
import com.dfbf.soundlink.user.adapter.out.persistence.mapper.UserMapper;
import com.dfbf.soundlink.user.adapter.out.persistence.repository.UserRepository;
import com.dfbf.soundlink.user.application.port.out.UserRepositoryPort;
import com.dfbf.soundlink.user.domain.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserJpaRepositoryAdapter implements UserRepositoryPort {
    private final UserRepository repository;

    @Override
    @Transactional
    public void save(User user) {
        try {
            // User 엔티티를 UserJpaEntity로 변환
            UserJpaEntity userJpaEntity = UserMapper.toJpa(user);

            // 변환된 엔티티를 JPA 리포지토리에 저장
            repository.save(userJpaEntity);
        } catch (DataAccessException e) {
            throw new RuntimeException("변환 에러: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("알 수 없는 에러: " + e.getMessage(), e);
        }
    }
}
