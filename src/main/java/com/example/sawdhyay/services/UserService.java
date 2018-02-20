package com.example.sawdhyay.services;

import com.example.sawdhyay.models.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
