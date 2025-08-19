package com.dfbf.soundlink.user.adapter.in.web.dto.request;

import com.dfbf.soundlink.user.application.port.in.command.CreateUser;
import com.dfbf.soundlink.user.domain.enums.SocialType;
import com.dfbf.soundlink.user.domain.vo.Email;
import com.dfbf.soundlink.user.domain.vo.LoginInfo;
import com.dfbf.soundlink.user.domain.vo.Nickname;
import com.dfbf.soundlink.user.domain.vo.SocialInfo;

public record UserSignReqDto(
        String nickName,
        SocialType socialType,
        String loginId,
        String password,
        String email
) {
    public CreateUser toCommand() {
        return new CreateUser(
            new Nickname(nickName), new SocialInfo(socialType, null), new LoginInfo(loginId, password), new Email(email)
        );
    }
}
