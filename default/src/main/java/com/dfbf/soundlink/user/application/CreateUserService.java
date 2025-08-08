package com.dfbf.soundlink.user.application;

import com.dfbf.soundlink.user.application.port.in.CreateUserUseCase;
import com.dfbf.soundlink.user.application.port.in.command.CreateUserCommand;
import com.dfbf.soundlink.user.application.port.in.response.CreateUserResponse;
import com.dfbf.soundlink.user.domain.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CreateUserService implements CreateUserUseCase {

    // private final UserRepositoryPort userRepositoryPort;

    @Override
    public CreateUserResponse createUser(CreateUserCommand command) {
        User user = new User().register(
                command.socialInfo(),
                command.loginInfo(),
                command.nickname(),
                command.email()
        );

        // DB 저장
        // userRepositoryPort.save(user);

        // 응답 DTO 변환
        return CreateUserResponse.success();
    }
}