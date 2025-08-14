package com.dfbf.soundlink.user.domain.entity;

import com.dfbf.soundlink.user.domain.vo.*;
import com.dfbf.soundlink.user.domain.enums.SocialType;
import com.dfbf.soundlink.global.common.ErrorMessages;
import com.dfbf.soundlink.user.domain.vo.*;
import lombok.Getter;

@Getter
public class User {
    private final UserNo id;
    //private ProfileMusic profileMusic;
    private SocialInfo socialInfo;
    private LoginInfo loginInfo;
    private Nickname nickname;
    private Email email;
    private TimeMetadata timeMetadata;

    public User() {
        this.id = new UserNo();
        this.socialInfo = new SocialInfo(SocialType.NONE, null);
    }

    // 신규 생성(JPA Entity → Domain)
    public User(UserNo id, SocialInfo socialInfo, LoginInfo loginInfo, Nickname nickname, Email email, TimeMetadata timeMetadata) {
        this.id = id;
        this.socialInfo = socialInfo;
        this.loginInfo = loginInfo;
        this.nickname = nickname;
        this.email = email;
        this.timeMetadata = timeMetadata;
    }

    /**
     * 도메인 생성
     * @param socialInfo
     * @param nickname
     * @param email
     * @return User
     */
    public User create(SocialInfo socialInfo, LoginInfo loginInfo, Nickname nickname, Email email) {
        if (!socialInfo.getSocialType().isTypeChangeable()) {
            throw new IllegalStateException(ErrorMessages.ALREADY_REGISTERED_SOCIAL_TYPE.getMsg());
        }

        this.socialInfo = socialInfo;
        this.loginInfo = new LoginInfo(loginInfo.getLoginId(), loginInfo.getPassword());
        this.nickname = nickname;
        this.email = email;
        this.timeMetadata = null;

        return this;
    }

    private boolean isEmptyLoginInfo() {
        return loginInfo == null;
    }

    /**
     * 비밀번호 변경
     * @param password
     */
    public void changePassword(String password) {
        if (isEmptyLoginInfo()) {
            throw new IllegalStateException(ErrorMessages.NO_LOGIN_INFO.getMsg());
        }

        this.loginInfo = new LoginInfo(loginInfo.getLoginId(), password);
    }
}
