package com.dfbf.soundlink.user.domain.vo;

import com.dfbf.soundlink.global.common.ErrorMessages;

public record Nickname(String value) {
    public Nickname {
        if (value == null || value.isBlank()) {
            throw new IllegalStateException(ErrorMessages.EMPTY_NICKNAME.getMsg());
        }
    }
}
