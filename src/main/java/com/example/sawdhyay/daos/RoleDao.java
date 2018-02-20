package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.Role;

public interface RoleDao {
    Role findByRole(String role);
}
