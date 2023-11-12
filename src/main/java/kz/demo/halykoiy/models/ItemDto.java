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
}
