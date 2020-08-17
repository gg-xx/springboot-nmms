package com.itany.nmms.service;

import com.itany.nmms.entity.User;

import java.util.List;

public interface UserService {

    int alterUser(User user);

    List<User> findAllBySelect(User user);

    int alterStatus(User user);
}
