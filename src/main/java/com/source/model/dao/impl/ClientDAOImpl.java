package com.source.model.dao.impl;

import com.source.model.dao.ClientDAO;
import com.source.model.entity.Client;
import com.source.model.entity.Prophylaxy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientDAOImpl implements ClientDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveOrUpdate(Client item) {
        saveOrUpdate(sessionFactory, item);
    }

    @Override
    public void save(Client item) {
        save(sessionFactory, item);
    }

    @Override
    public void delete(Client item) {
        delete(sessionFactory, item);
    }

    @Override
    public Optional<Client> get(Class<Client> item, int id) {
        return get(sessionFactory, item, id);
    }

    @Override
    public List<Client> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Client", Client.class).getResultList();
    }

    @Override
    public Optional<Client> getByPhone(String phone) {
        Session session = sessionFactory.getCurrentSession();

        Query<Client> query = session
                .createQuery("from Client c where c.phone like :thePhone", Client.class)
                .setParameter("thePhone", "%" + phone + "%");
        return Optional.of(query.getSingleResult());
    }

    @Override
    public List<Client> searchClientsByLastName(String lastName) {
        Session session = sessionFactory.getCurrentSession();

        Query<Client> query = session
                .createQuery("from Client c where c.lastName like :name", Client.class)
                .setParameter("name", "%" + lastName + "%");
        return query.getResultList();
    }

    @Override
    public Optional<Client> searchByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();

        Query<Client> query = session
                .createQuery("from Client c where c.email like :theEmail", Client.class)
                .setParameter("theEmail", "%" + email + "%");
        return Optional.of(query.getSingleResult());
    }

    @Override //TODO search by address
    public List<Client> searchByAddress(String address) {
        Session session = sessionFactory.getCurrentSession();

        Query<Client> query = session
                .createQuery("from Client c where c.city like :add or c.street like :add", Client.class)
                .setParameter("add", "%" + address + "%");
        return query.getResultList();
    }

    @Override // TODO
    public List<Prophylaxy> getProphylaxiesNextVaccinationDate(Client client) {
        return null;
    }
}
