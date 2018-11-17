package com.source.model.dao;

import com.source.model.entity.Client;
import com.source.model.entity.Prophylaxy;

import java.util.List;
import java.util.Optional;

public interface ClientDAO extends GenericDAO<Client> {

    Optional<Client> getByPhone(String phone);

    List<Client> searchClientsByLastName(String lastName);

    Optional<Client> searchByEmail(String email);

    List<Client> searchByAddress(String address);

    List<Prophylaxy> getProphylaxiesNextVaccinationDate(Client client);


}
