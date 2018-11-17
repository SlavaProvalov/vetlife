package com.source.model.entity;


import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "medicine")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "title")
    private String title;

    @Column(name = "quantity")
    private int quantity;

//    @Size(min = 1, max = 7, message = "no-no-no")
//    @Pattern(regexp = "^[0-9]+\\.[0-9]{2}$", message = "bad boy")
    @Column(name = "price")
    private int price;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {PERSIST, MERGE, DETACH, REFRESH})
    @JoinTable(name = "medicine_order",
            joinColumns = @JoinColumn(name = "medicine_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders;


    public Medicine() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medicine)) return false;

        Medicine medicine = (Medicine) o;

        if (getId() != medicine.getId()) return false;
        if (getType() != null ? !getType().equals(medicine.getType()) : medicine.getType() != null) return false;
        return getTitle() != null ? getTitle().equals(medicine.getTitle()) : medicine.getTitle() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        return result;
    }

    @ManyToMany(mappedBy = "medicines")
    private Collection<Order> orders2;

    public Collection<Order> getOrders2() {
        return orders2;
    }

    public void setOrders2(Collection<Order> orders2) {
        this.orders2 = orders2;
    }
}
