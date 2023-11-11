package kz.demo.halykoiy.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class IncomeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;

    private Double avgTransactionPrice;
    private Double revenueTotal;
    private Double spendingTotal;
    private Double marketingSpendingTotal;
    private Double salarySpendingTotal;
    private Double resourceSpendingTotal;
    private Double otherSpendingTotal;
}
