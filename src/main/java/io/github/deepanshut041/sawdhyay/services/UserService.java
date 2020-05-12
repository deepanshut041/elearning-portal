package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.models.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
