package kz.demo.halykoiy.repos;

import kz.demo.halykoiy.entities.IncomeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeInfoRepository extends JpaRepository<IncomeInfo, Long> {
    // Methods for custom queries related to IncomeInfo
}