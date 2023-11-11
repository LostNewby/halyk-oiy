package kz.demo.halykoiy.services;

import kz.demo.halykoiy.entities.Inventory;
import kz.demo.halykoiy.entities.User;
import kz.demo.halykoiy.models.InventoryDto;
import kz.demo.halykoiy.models.InventoryOverallDto;
import kz.demo.halykoiy.repos.InventoryRepository;
import kz.demo.halykoiy.repos.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public void addInventory(User user, InventoryDto inventoryDto) {
        Inventory inventory = new Inventory();
        inventory.setUser(user);
        inventory.setItem(itemRepository.findById(inventoryDto.getItemId()).orElseThrow(() -> new RuntimeException("Item not found")));
        inventory.setCount(inventoryDto.getCount());
        inventoryRepository.save(inventory);
    }

    public InventoryOverallDto getMyInventory(User user) {
        return convertToDto(inventoryRepository.findInventoriesByUser(user));
    }

    public InventoryOverallDto convertToDto(List<Inventory> inventories) {
        double totalPrice = 0;
        int lowStockCount = 0;
        int outOfStockCount = 0;

        for (Inventory inventory : inventories) {
            totalPrice += inventory.getItem().getPrice() * inventory.getCount();

            if (inventory.getCount() < 5) {
                lowStockCount++;
            }

            if (inventory.getCount() == 0) {
                outOfStockCount++;
            }
        }

        return InventoryOverallDto.builder()
                .price(totalPrice)
                .total(inventories.size())
                .lowStock(lowStockCount)
                .outOfStock(outOfStockCount)
                .build();
    }
}