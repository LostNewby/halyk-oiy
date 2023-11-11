package kz.demo.halykoiy.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncomeInfoDto {
    private Long userId;
    private Double avgTransactionPrice;
    private Double revenueTotal;
    private Double spendingTotal;
    private Double marketingSpendingTotal;
    private Double salarySpendingTotal;
    private Double resourceSpendingTotal;
    private Double otherSpendingTotal;
}

