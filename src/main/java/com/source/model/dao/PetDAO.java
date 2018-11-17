package com.source.model.dao;

import com.source.model.entity.*;

import java.util.List;
import java.util.Optional;

public interface PetDAO extends GenericDAO<Pet> {

    Optional<Client> getClient(Pet pet);

    List<Pet> searchByType(String type);

    List<Pet> searchByAlias(String alias);

    List<Pet> searchByKind(String kind);

    Optional<Pet> searchByPetIdentifier(String identifier);

    List<Pet> searchByPassport(String passport);

    List<Appointment> getAppointments(Pet pet);

    List<Prophylaxy> getProphylaxies(Pet pet);

    List<RabiesTest> getRabiesTests(Pet pet);

    List<Order> getOrders(Pet pet);

}
