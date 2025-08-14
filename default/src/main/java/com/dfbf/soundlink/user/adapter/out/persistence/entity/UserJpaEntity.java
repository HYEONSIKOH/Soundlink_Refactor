package com.dfbf.soundlink.user.adapter.out.persistence.entity;

import com.dfbf.soundlink.user.domain.enums.SocialType;
import com.dfbf.soundlink.user.domain.vo.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class UserJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Embedded
    private UserNo externalId;

    /*@JsonIgnore*/
//    @OneToOne(/*fetch = FetchType.LAZY, */cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "profile_music_id")
//    private ProfileMusic profileMusic;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "nickname", unique = true, nullable = false))
    private Nickname nickname;

    @Embedded
    private SocialInfo socialInfo;

    @Embedded
    private LoginInfo loginInfo;

    @Embedded
    private Email email;

    @Embedded
    private TimeMetadata timeMetadata;

    @Builder
    public UserJpaEntity(UserNo externalId, Nickname nickname, SocialInfo socialInfo, LoginInfo loginInfo, Email email) {
        this.externalId = externalId;
        this.nickname = nickname;
        this.socialInfo = socialInfo;
        this.loginInfo = loginInfo;
        this.email = email;
        //this.profileMusic = new ProfileMusic(null);
    }
}
