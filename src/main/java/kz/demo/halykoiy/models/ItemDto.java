package kz.demo.halykoiy.models;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private Long uniqueNumber;
    private String name;
    private Double price;
    private String imageUrl;

    public ItemDto(Long uniqueNumber, String name, Double price) {
        this.uniqueNumber = uniqueNumber;
        this.name = name;
        this.price = price;
    }
}
