package kz.demo.halykoiy.services;

import kz.demo.halykoiy.entities.Inventory;
import kz.demo.halykoiy.entities.User;
import kz.demo.halykoiy.models.InventoryDto;
import kz.demo.halykoiy.models.ItemDto;
import kz.demo.halykoiy.repos.InventoryRepository;
import kz.demo.halykoiy.repos.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public List<InventoryDto> getMyInventory(User user) {
        return inventoryRepository.findInventoriesByUser(user).stream()
                .map(inventory -> new InventoryDto(inventory.getItem(), inventory.getCount()))
                .collect(Collectors.toList());
    }

}