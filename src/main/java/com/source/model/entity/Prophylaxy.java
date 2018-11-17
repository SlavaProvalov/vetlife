package com.source.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "prophylaxy")
public class Prophylaxy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "vaccine")
    private String vaccine;

    @Column(name = "next_vaccination_date")
    private LocalDate nextVaccinationDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {PERSIST, MERGE, DETACH, REFRESH})
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    public Prophylaxy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public LocalDate getNextVaccinationDate() {
        return nextVaccinationDate;
    }

    public void setNextVaccinationDate(LocalDate nextVaccinationDate) {
        this.nextVaccinationDate = nextVaccinationDate;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prophylaxy)) return false;

        Prophylaxy that = (Prophylaxy) o;

        if (getId() != that.getId()) return false;
        if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null) return false;
        if (getVaccine() != null ? !getVaccine().equals(that.getVaccine()) : that.getVaccine() != null) return false;
        if (getNextVaccinationDate() != null ? !getNextVaccinationDate().equals(that.getNextVaccinationDate()) : that.getNextVaccinationDate() != null)
            return false;
        return getAppointment() != null ? getAppointment().equals(that.getAppointment()) : that.getAppointment() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getVaccine() != null ? getVaccine().hashCode() : 0);
        result = 31 * result + (getNextVaccinationDate() != null ? getNextVaccinationDate().hashCode() : 0);
        result = 31 * result + (getAppointment() != null ? getAppointment().hashCode() : 0);
        return result;
    }
}
