package com.source.model.dao.impl;

import com.source.model.dao.RoleDao;
import com.source.model.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Role findRoleByName(String theRoleName) {
        Session session = sessionFactory.getCurrentSession();

        Query<Role> query = session.createQuery("from Role where name=:rName", Role.class);
        query.setParameter("rName", theRoleName);

        Role role;

        try {
            role = query.getSingleResult();
        } catch (Exception e) {
            role = null;
        }
        return role;
    }

    @Override
    public void saveOrUpdate(Role item) {
        saveOrUpdate(sessionFactory, item);
    }

    @Override
    public void save(Role item) {
        save(sessionFactory, item);
    }

    @Override
    public void delete(Role item) {
        delete(sessionFactory, item);
    }

    @Override
    public Optional<Role> get(Class<Role> item, int id) {
        return Optional.empty();
    }

    @Override
    public List<Role> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Role ", Role.class).getResultList();
    }
}
