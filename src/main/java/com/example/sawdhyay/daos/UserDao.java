package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.User;

public  interface UserDao {


    User findByEmail(String email);
    void save(User user);
}
