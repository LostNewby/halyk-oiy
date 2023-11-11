package kz.demo.halykoiy.repos;

import kz.demo.halykoiy.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // Custom queries for Item can be added here
}
