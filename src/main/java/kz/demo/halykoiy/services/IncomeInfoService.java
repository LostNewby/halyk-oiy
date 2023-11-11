package kz.demo.halykoiy.services;

import kz.demo.halykoiy.entities.IncomeInfo;
import kz.demo.halykoiy.entities.User;
import kz.demo.halykoiy.models.IncomeInfoDto;
import kz.demo.halykoiy.repos.IncomeInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class IncomeInfoService {

    private final IncomeInfoRepository incomeInfoRepository;

    @Transactional
    public void setIncomeInfo(User user, IncomeInfoDto incomeInfoDto) {
        // Convert DTO to Entity and persist
        IncomeInfo incomeInfo = new IncomeInfo();
        incomeInfo.builder()
                .user(incomeInfo.getUser())
                .avgTransactionPrice(incomeInfoDto.getAvgTransactionPrice())
                .revenueTotal(incomeInfoDto.getRevenueTotal())
                .marketingSpendingTotal(incomeInfoDto.getMarketingSpendingTotal())
                .spendingTotal(incomeInfoDto.getSpendingTotal())
                .resourceSpendingTotal(incomeInfoDto.getResourceSpendingTotal())
                .salarySpendingTotal(incomeInfoDto.getSalarySpendingTotal())
                .otherSpendingTotal(incomeInfoDto.getOtherSpendingTotal())
                .build();
        incomeInfoRepository.save(incomeInfo);
    }
}