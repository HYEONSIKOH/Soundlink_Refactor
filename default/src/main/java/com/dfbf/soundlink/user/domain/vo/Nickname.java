package com.dfbf.soundlink.user.domain.vo;

import com.dfbf.soundlink.global.common.ErrorMessages;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Nickname {
    @Column(name = "nickname", nullable = false, unique = true)
    private String value;

    public Nickname(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalStateException(ErrorMessages.EMPTY_NICKNAME.getMsg());
        }
        this.value = value;
    }
}
