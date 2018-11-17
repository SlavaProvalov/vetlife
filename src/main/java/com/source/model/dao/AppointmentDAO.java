package com.source.model.dao;

import com.source.model.entity.Appointment;
import com.source.model.entity.Prophylaxy;
import com.source.model.entity.RabiesTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentDAO extends GenericDAO<Appointment> {

    List<Appointment> searchByDate(LocalDateTime fromDate, LocalDateTime toDate);

    List<Appointment> searchByDiagnosis(String diagnosis);

    Optional<RabiesTest> getRabiesTest(Appointment appointment);

    List<Prophylaxy> getProphylaxies(Appointment appointment);

}
