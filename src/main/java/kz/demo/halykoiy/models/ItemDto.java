package kz.demo.halykoiy.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private Long uniqueNumber;
    private String name;
    private Double price;
}
