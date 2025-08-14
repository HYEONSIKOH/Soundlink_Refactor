package com.dfbf.soundlink.user.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Email {

    @Column(name = "email", nullable = false, unique = true)
    private String value;

    public Email(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Email must not be blank");
        }
        this.value = value;
    }
}
