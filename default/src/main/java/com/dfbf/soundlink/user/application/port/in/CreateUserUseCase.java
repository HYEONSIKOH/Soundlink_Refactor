package com.dfbf.soundlink.user.application.port.in;

import com.dfbf.soundlink.user.application.port.in.command.CreateUser;
import com.dfbf.soundlink.user.application.port.in.response.CreateUserResponse;


public interface CreateUserUseCase {
    CreateUserResponse createUser(CreateUser command);
}
