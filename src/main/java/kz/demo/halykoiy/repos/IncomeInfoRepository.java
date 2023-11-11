package kz.demo.halykoiy.repos;

import kz.demo.halykoiy.entities.IncomeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeInfoRepository extends JpaRepository<IncomeInfo, Long> {
    // Methods for custom queries related to IncomeInfo

    @Query(value = "SELECT avg(avgTransactionPrice) FROM IncomeInfo WHERE user IN (SELECT u FROM User u WHERE (u.latitude >= ?1 AND u.latitude <= ?2) AND (u.longitude >= ?3 AND u.longitude <= ?4))")
    Double getAverageInRadius(Double neg_new_latitude, Double pos_new_latitude, Double neg_new_longitude, Double pos_new_longitude);
}