package com.source.model.entity;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "rabies_test")
public class RabiesTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "result")
    private int result;

    @Column(name = "form")
    private String form;

    @Column(name = "form_number")
    private String formNumber;

    @OneToOne(fetch = FetchType.LAZY, cascade = {PERSIST, MERGE, DETACH, REFRESH})
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    public RabiesTest() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getFormNumber() {
        return formNumber;
    }

    public void setFormNumber(String formNumber) {
        this.formNumber = formNumber;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment pet) {
        this.appointment = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RabiesTest)) return false;

        RabiesTest that = (RabiesTest) o;

        if (getId() != that.getId()) return false;
        if (getResult() != that.getResult()) return false;
        if (getForm() != null ? !getForm().equals(that.getForm()) : that.getForm() != null) return false;
        if (getFormNumber() != null ? !getFormNumber().equals(that.getFormNumber()) : that.getFormNumber() != null)
            return false;
        return getAppointment() != null ? getAppointment().equals(that.getAppointment()) : that.getAppointment() == null;

    }

    @Override
    public int hashCode() {
        int result1 = getId();
        result1 = 31 * result1 + getResult();
        result1 = 31 * result1 + (getForm() != null ? getForm().hashCode() : 0);
        result1 = 31 * result1 + (getFormNumber() != null ? getFormNumber().hashCode() : 0);
        result1 = 31 * result1 + (getAppointment() != null ? getAppointment().hashCode() : 0);
        return result1;
    }
}
