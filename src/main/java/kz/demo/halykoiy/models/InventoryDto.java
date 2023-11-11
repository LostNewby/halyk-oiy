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
    private Integer count;
}

