package com.source.model.dao;

import com.source.model.entity.Appointment;
import com.source.model.entity.Client;
import com.source.model.entity.Prophylaxy;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProphylaxyDAO extends GenericDAO<Prophylaxy> {

    Optional<Appointment> getAppointmentByProphylaxy(Prophylaxy prophylaxy);

    List<Prophylaxy> searchByVaccine(String vaccine);

    List<Client> getClientsByNextVaccinationDate(LocalDate date);

}
