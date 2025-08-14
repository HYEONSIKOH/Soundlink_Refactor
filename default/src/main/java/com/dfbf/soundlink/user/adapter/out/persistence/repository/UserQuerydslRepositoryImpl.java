package com.dfbf.soundlink.user.adapter.out.persistence.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserQuerydslRepositoryImpl implements UserQuerydslRepository {

    private final JPAQueryFactory query;
}
