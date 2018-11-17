package com.source.model.dao;

import com.source.model.entity.Medicine;
import com.source.model.entity.Order;
import com.source.model.entity.Pet;
import com.source.model.entity.VetService;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderDAO extends GenericDAO<Order> {

    List<Order> searchByDates(LocalDateTime fromDate, LocalDateTime toDate);

    List<Medicine> getMedicines(Order order);

    List<VetService> getVetServices(Order order);

    List<Pet> getPets(Order order);

}
