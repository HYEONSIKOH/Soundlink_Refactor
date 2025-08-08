package com.dfbf.soundlink.user.domain.entity;

import com.dfbf.soundlink.user.domain.vo.*;
import com.dfbf.soundlink.user.domain.enums.SocialType;
import com.dfbf.soundlink.global.common.ErrorMessages;
import com.dfbf.soundlink.user.domain.vo.*;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;

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
        id = new UserNo(UUID.randomUUID().toString());
        this.socialInfo = new SocialInfo(SocialType.NONE, null);
    }

    /**
     * 회원가입
     * @param socialInfo
     * @param nickname
     * @param email
     * @return User
     */
    public User register(SocialInfo socialInfo, LoginInfo loginInfo, Nickname nickname, Email email) {
        if (!socialInfo.socialType().isTypeChangeable()) {
            throw new IllegalStateException(ErrorMessages.ALREADY_REGISTERED_SOCIAL_TYPE.getMsg());
        }

        this.socialInfo = socialInfo;
        this.loginInfo = new LoginInfo(loginInfo.loginId(), null);
        this.nickname = nickname;
        this.email = email;
        this.timeMetadata = new TimeMetadata(new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));

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

        this.loginInfo = new LoginInfo(loginInfo.loginId(), password);
    }
}
