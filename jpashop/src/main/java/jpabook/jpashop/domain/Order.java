package jpabook.jpashop.domain;

import jakarta.persistence.*;
import org.h2.engine.User;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;


}
