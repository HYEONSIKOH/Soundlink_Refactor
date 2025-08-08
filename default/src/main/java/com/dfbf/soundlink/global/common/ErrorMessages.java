package com.dfbf.soundlink.global.common;

import lombok.Getter;

@Getter
public enum ErrorMessages {

    // 회원가입
    NO_LOGIN_INFO("No Login Information"),
    EMPTY_NICKNAME("Empty Nickname"),

    // 소셜 로그인 타입
    ALREADY_REGISTERED_SOCIAL_TYPE("Already registered social type");

    private String msg;

    ErrorMessages(String msg) {
        this.msg = msg;
    }
}
