package com.source.model.dao;

import com.source.model.entity.RabiesTest;

import java.time.LocalDate;
import java.util.List;

public interface RabiesTestDAO extends GenericDAO<RabiesTest> {

    List<RabiesTest> searchByDates(LocalDate fromDate, LocalDate toDate);

}
