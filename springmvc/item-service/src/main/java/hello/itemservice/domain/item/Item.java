package hello.itemservice.domain.item;

import lombok.Data;

@Data // 사용하면 위험함, DTO 쓰면 그냥 데이터 써도 OK (확인해보고 쓰자)
//@Getter @Setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price; // Integer 해야 가격 안들어가는 경우 고려 가능 (0이 들어가는 거랑 다른 거 알지)
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
