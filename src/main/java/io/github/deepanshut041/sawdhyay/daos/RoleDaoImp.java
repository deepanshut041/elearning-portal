package io.github.deepanshut041.sawdhyay.daos;

import io.github.deepanshut041.sawdhyay.models.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoleDaoImp implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public Role findByRole(String role) {
        List<Role> roles = new ArrayList<Role>();
        roles = this.sessionFactory.getCurrentSession()
                .createQuery("from Role where role=?")
                .setParameter(0, role).list();
        if (roles.size() > 0) {
            return roles.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Role findById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Role m_role = (Role) session.load(Role.class, new Integer(id));
        return m_role;
    }
}
