package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.daos.RoleDao;
import io.github.deepanshut041.sawdhyay.daos.UserDao;
import io.github.deepanshut041.sawdhyay.models.Role;
import io.github.deepanshut041.sawdhyay.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    @Transactional
    public User findUserByEmail(String email) {
        return this.userDao.findByEmail(email);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleDao.findById(1);
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userDao.save(user);
    }
}
