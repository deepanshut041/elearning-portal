package io.github.deepanshut041.sawdhyay.daos;

import io.github.deepanshut041.sawdhyay.models.Role;

public interface RoleDao {
    Role findByRole(String role);
    Role findById(int id);
}
