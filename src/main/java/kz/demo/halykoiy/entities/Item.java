package kz.demo.halykoiy.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {
    @Id
    private Long uniqueNumber;

    private String name;
    private Double price;

    // Assume there's a 'Sales' entity that connects to this field
    private Long salesId;
}
