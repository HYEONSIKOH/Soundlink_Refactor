package com.dfbf.soundlink.user.adapter.out.persistence.mapper;

import com.dfbf.soundlink.user.adapter.out.persistence.entity.UserJpaEntity;
import com.dfbf.soundlink.user.domain.entity.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class UserMapper {
    // 도메인 → JPA (신규 생성용)
    public static UserJpaEntity toJpa(User domain) {
        return new UserJpaEntity(
                domain.getId(),
                domain.getNickname(),
                domain.getSocialInfo(),
                domain.getLoginInfo(),
                domain.getEmail()
        );
    }

    // JPA → 도메인 (복원용)
    public static User toDomain(UserJpaEntity e) {
        return new User(
                e.getExternalId(),
                e.getSocialInfo(),
                e.getLoginInfo(),
                e.getNickname(),
                e.getEmail(),
                e.getTimeMetadata()
        );
    }

}
