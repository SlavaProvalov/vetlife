package com.source.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "alias")
    private String alias;

    @Column(name = "sex")
    private Boolean sex;

    @Column(name = "kind")
    private String kind;

    @Column(name = "color")
    private String color;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "pet_identifier")
    private String petIdentifier;

    @Column(name = "passport")
    private String passport;

    @Column(name = "death_date")
    private LocalDate deathDate;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {PERSIST, MERGE, DETACH, REFRESH})
    @JoinColumn(name = "client_id")
    private Client owner;

    @OneToMany(mappedBy = "pet", fetch = FetchType.LAZY,
            cascade = {PERSIST, MERGE, DETACH, REFRESH})
    private List<Appointment> appointments;


    @Column(name = "is_sterilized")
    private boolean isSterilized;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {PERSIST, MERGE, DETACH, REFRESH})
    @JoinTable(name = "pet_order",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders;

    public Pet() {
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPetIdentifier() {
        return petIdentifier;
    }

    public void setPetIdentifier(String petIdentifier) {
        this.petIdentifier = petIdentifier;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }


    public boolean isSterilized() {
        return isSterilized;
    }

    public void setSterilized(boolean sterilized) {
        isSterilized = sterilized;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addAppointment(Appointment appointment) {
        if (appointments == null) {
            appointments = new ArrayList<>();
        }
        appointments.add(appointment);
    }


    public void addOrder(Order order) {
        if (orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(order);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;

        Pet pet = (Pet) o;

        if (getId() != pet.getId()) return false;
        if (getType() != null ? !getType().equals(pet.getType()) : pet.getType() != null) return false;
        if (getAlias() != null ? !getAlias().equals(pet.getAlias()) : pet.getAlias() != null) return false;
        if (getSex() != null ? !getSex().equals(pet.getSex()) : pet.getSex() != null) return false;
        if (getKind() != null ? !getKind().equals(pet.getKind()) : pet.getKind() != null) return false;
        if (getColor() != null ? !getColor().equals(pet.getColor()) : pet.getColor() != null) return false;
        if (getBirthDate() != null ? !getBirthDate().equals(pet.getBirthDate()) : pet.getBirthDate() != null)
            return false;
        if (getPetIdentifier() != null ? !getPetIdentifier().equals(pet.getPetIdentifier()) : pet.getPetIdentifier() != null)
            return false;
        if (getPassport() != null ? !getPassport().equals(pet.getPassport()) : pet.getPassport() != null) return false;
        return getDeathDate() != null ? getDeathDate().equals(pet.getDeathDate()) : pet.getDeathDate() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getAlias() != null ? getAlias().hashCode() : 0);
        result = 31 * result + (getSex() != null ? getSex().hashCode() : 0);
        result = 31 * result + (getKind() != null ? getKind().hashCode() : 0);
        result = 31 * result + (getColor() != null ? getColor().hashCode() : 0);
        result = 31 * result + (getBirthDate() != null ? getBirthDate().hashCode() : 0);
        result = 31 * result + (getPetIdentifier() != null ? getPetIdentifier().hashCode() : 0);
        result = 31 * result + (getPassport() != null ? getPassport().hashCode() : 0);
        result = 31 * result + (getDeathDate() != null ? getDeathDate().hashCode() : 0);
        return result;
    }
}
