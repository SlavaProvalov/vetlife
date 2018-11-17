package com.source.model.dao;

import com.source.model.entity.Order;
import com.source.model.entity.VetService;

import java.util.List;

public interface VetServiceDAO extends GenericDAO<VetService> {

    List<VetService> searchByType(String type);

    List<Order> getOrdersByVetService(VetService service);

}
