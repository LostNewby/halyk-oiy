package kz.demo.halykoiy.services;

import kz.demo.halykoiy.entities.IncomeInfo;
import kz.demo.halykoiy.entities.Role;
import kz.demo.halykoiy.entities.User;
import kz.demo.halykoiy.models.IncomeInfoDto;
import kz.demo.halykoiy.repos.IncomeInfoRepository;
import kz.demo.halykoiy.repos.UserRepository;
import kz.demo.halykoiy.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public List<IncomeInfoDto> getAverageTransactionPriceInRadius(Integer distance) throws IllegalAccessException {
        User user = userRepository.findByPhone("7754351960").get();

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

//        return incomeInfoRepository.getAverageInRadius(neg_new_latitude, pos_new_latitude, neg_new_longitude, pos_new_longitude);
        Random rand = new Random();
        IncomeInfoDto info = new IncomeInfoDto();
        info.setAvgTransactionPrice(rand.nextDouble(4286.0 - 847.0) + 847.0);
        info.setRevenueTotal(rand.nextDouble(988890.0 - 49085.0) + 49085.0);
        info.setOtherSpendingTotal(rand.nextDouble(753241.0 - 177548.0) + 177548.0);
        info.setMarketingSpendingTotal(rand.nextDouble(854700.0 - 301792.0) + 301792.0);
        info.setSpendingTotal(rand.nextDouble(1023420.0 - 544486.0) + 544486.0);
        info.setResourceSpendingTotal(rand.nextDouble(198096.0 - 32227.0) + 32227.0);
        info.setSalarySpendingTotal(rand.nextDouble(99821.0 - 56996.0) + 56996.0);
        info.setIncomeTotal(rand.nextDouble(129821.0 - 38996.0) + 38996.0);
        ArrayList<IncomeInfoDto> res = new ArrayList<>();
        IncomeInfo mine = incomeInfoRepository.findById(9L).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        IncomeInfoDto minetoo = IncomeInfoDto.builder()
                .avgTransactionPrice(mine.getAvgTransactionPrice())
                .resourceSpendingTotal(mine.getResourceSpendingTotal())
                .salarySpendingTotal(mine.getSalarySpendingTotal())
                .marketingSpendingTotal(mine.getMarketingSpendingTotal())
                .revenueTotal(mine.getRevenueTotal())
                .spendingTotal(mine.getSpendingTotal())
                .otherSpendingTotal(mine.getOtherSpendingTotal())
                .incomeTotal(135502.0).build();
        res.add(info);
        res.add(minetoo);
        return res;
    }
}