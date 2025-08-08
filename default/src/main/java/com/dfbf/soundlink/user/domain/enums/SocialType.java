package com.dfbf.soundlink.user.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 소셜 로그인
 */
public enum SocialType {
    NONE {
        public boolean isTypeChangeable() { return true; }
    },
    KAKAO,
    GOOGLE,
    NAVER;

    /**
     * 타입 변경 여부
     */
    public boolean isTypeChangeable() {
        return false;
    }
}
