package kz.demo.halykoiy.services;

import kz.demo.halykoiy.entities.IncomeInfo;
import kz.demo.halykoiy.entities.Role;
import kz.demo.halykoiy.entities.User;
import kz.demo.halykoiy.models.IncomeInfoDto;
import kz.demo.halykoiy.repos.IncomeInfoRepository;
import kz.demo.halykoiy.repos.UserRepository;
import kz.demo.halykoiy.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class IncomeInfoService {

    private final IncomeInfoRepository incomeInfoRepository;
    private final UserRepository userRepository;

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

    public Double getAverageTransactionPriceInRadius(Integer distance) throws IllegalAccessException {
        User user = userRepository.findByPhone(SecurityUtils.getUserPhoneNumber()).get();

        if (!user.getRole().equals(Role.SERVICE)) {
            throw new IllegalAccessException("User has no access to service!");
        }

        Double earth = 6378.137,  //radius of the earth in kilometer
                pi = Math.PI,
                m = (1 / ((2 * pi / 360) * earth)) / 1000;  //1 meter in degree

        var pos_new_latitude = user.getLatitude() + (distance * m);
        var neg_new_latitude = user.getLatitude() + (-distance * m);

        var pos_new_longitude = user.getLongitude() + (distance * m) / Math.cos(user.getLongitude() * (pi / 180));
        var neg_new_longitude = user.getLongitude() + (-distance * m) / Math.cos(user.getLongitude() * (pi / 180));

        return incomeInfoRepository.getAverageInRadius(neg_new_latitude, pos_new_latitude, neg_new_longitude, pos_new_longitude);
    }
}