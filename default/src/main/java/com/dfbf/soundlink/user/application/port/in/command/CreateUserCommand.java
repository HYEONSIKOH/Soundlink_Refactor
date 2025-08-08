package com.dfbf.soundlink.user.application.port.in.command;

import com.dfbf.soundlink.user.domain.vo.Email;
import com.dfbf.soundlink.user.domain.vo.LoginInfo;
import com.dfbf.soundlink.user.domain.vo.Nickname;
import com.dfbf.soundlink.user.domain.vo.SocialInfo;

public record CreateUserCommand(
        Nickname nickname,
        SocialInfo socialInfo,
        LoginInfo loginInfo,
        Email email) {
}

/**
 * Command는 도메인에 가까운 계층이기 때문
 * 	•	Command는 Application Layer에 속하지만,
 * 	•	도메인의 유스케이스를 정확하게 모델링하기 위해 존재해.
 * 	•	그러므로 **String보다 의미 있는 타입(VO)**를 쓰는 게 더 도메인 친화적이야.
 */
