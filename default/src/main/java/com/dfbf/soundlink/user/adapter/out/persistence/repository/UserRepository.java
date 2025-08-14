package com.dfbf.soundlink.user.adapter.out.persistence.repository;

import com.dfbf.soundlink.user.adapter.out.persistence.entity.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserJpaEntity, Long> {
}
