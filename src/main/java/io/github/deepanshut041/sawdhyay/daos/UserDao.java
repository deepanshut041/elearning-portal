package io.github.deepanshut041.sawdhyay.daos;

import io.github.deepanshut041.sawdhyay.models.User;

public  interface UserDao {


    User findByEmail(String email);
    void save(User user);
}
