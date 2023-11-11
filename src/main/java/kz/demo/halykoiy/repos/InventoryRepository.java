package kz.demo.halykoiy.repos;


import kz.demo.halykoiy.entities.Inventory;
import kz.demo.halykoiy.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findInventoriesByUser(User user);
}