package jpabook.jpashop.domain;

import jakarta.persistence.*;

@Entity
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Address address;
    private DeliveryStatus deliveryStatus;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
