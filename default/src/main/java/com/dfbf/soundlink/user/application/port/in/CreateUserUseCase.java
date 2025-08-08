package com.dfbf.soundlink.user.application.port.in;

import com.dfbf.soundlink.user.application.port.in.command.CreateUserCommand;
import com.dfbf.soundlink.user.application.port.in.response.CreateUserResponse;


public interface CreateUserUseCase {
    CreateUserResponse createUser(CreateUserCommand command);
}
