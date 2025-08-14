package com.dfbf.soundlink.user.domain.vo;

import com.dfbf.soundlink.user.domain.enums.SocialType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class SocialInfo {
    @Enumerated(EnumType.STRING)
    @Column(name = "social_type", nullable = false)
    private SocialType socialType;

    @Column(name = "social_id", nullable = true)
    private Long socialId;

    public SocialInfo(SocialType socialType, Long socialId) {
        if (socialType == null) { socialType = SocialType.NONE; }
        this.socialType = socialType;
        this.socialId = socialId;
    }
}
