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
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "uniqueNumber")
    private Item item;

    private Integer count;
}
