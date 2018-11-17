package com.source.model.dao;

import com.source.model.entity.Medicine;
import com.source.model.entity.Order;

import java.util.List;

public interface MedicineDAO extends GenericDAO<Medicine> {

    List<Medicine> searchByType(String type);

    List<Medicine> searchByLessQuantity(int quantity);

    List<Order> getOrdersByMedicine(Medicine medicine);


}
