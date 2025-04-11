package hello.itemservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "item") //객체명이랑 같으면 생략가능
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name", length = 10) // 스프링부트랑 같이 쓰면 자동으로 언더스코어 방식으로 변환해주긴 함.
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
