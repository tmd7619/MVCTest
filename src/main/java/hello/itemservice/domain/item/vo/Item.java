package hello.itemservice.domain.item.vo;

import lombok.Getter;
import lombok.Setter;

// @Data 는 되도록이면 쓰지 않는게 좋다 .. (예기치 못한 상황이 발생할 수 있음. 모든 롬복을 불러오기에)
@Getter
@Setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity; // int가 아닌 이유? 0이 무조건 들어가야 하고, null이 들어가지 않기 때문에(int는 init default = 0)


    public Item() {

    }
    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

}
