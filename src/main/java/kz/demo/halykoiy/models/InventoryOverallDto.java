package kz.demo.halykoiy.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryOverallDto {
    private Double price;
    private Integer total;
    private Integer lowStock;
    private Integer outOfStock;
}
