package kz.demo.halykoiy.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.demo.halykoiy.entities.Item;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto {
    private Long itemId;
    private Item item;
    private Integer count;

    public InventoryDto(Item item, Integer count) {
        this.itemId = item.getUniqueNumber();
        this.item = item;
        this.count = count;
    }
}

