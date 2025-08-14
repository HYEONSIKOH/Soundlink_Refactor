package com.dfbf.soundlink.user.application.port.out;

import com.dfbf.soundlink.user.domain.entity.User;

public interface UserRepositoryPort {
    void save(User user);
}
