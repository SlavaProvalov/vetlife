package com.source.model.service.impl;

import com.source.model.dao.ClientDAO;
import com.source.model.entity.Client;
import com.source.model.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO clientDAO;

    @Override
    @Transactional
    public void saveOrUpdate(Client item) {
        clientDAO.saveOrUpdate(item);
    }

    @Override
    @Transactional
    public void delete(Client item) {
        clientDAO.delete(item);
    }

    @Override
    @Transactional
    public Optional<Client> get(Class<Client> item, int id) {
        return clientDAO.get(item, id);
    }

    @Override
    @Transactional
    public List<Client> getAll() {
        return clientDAO.getAll();
    }
}
