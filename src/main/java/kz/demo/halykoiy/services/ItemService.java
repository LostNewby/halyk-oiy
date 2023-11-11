package kz.demo.halykoiy.services;

import kz.demo.halykoiy.entities.Item;
import kz.demo.halykoiy.models.ItemDto;
import kz.demo.halykoiy.repos.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public ItemDto createItem(ItemDto itemDto) {
        Item item = new Item(); // Assuming you have a default constructor
        item.setUniqueNumber(itemDto.getUniqueNumber());
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        Item savedItem = itemRepository.save(item);
        return new ItemDto(savedItem.getUniqueNumber(), savedItem.getName(), savedItem.getPrice());
    }

    public List<ItemDto> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return items.stream().map(item -> new ItemDto(item.getUniqueNumber(), item.getName(), item.getPrice(), item.getImageUrl()))
                .collect(Collectors.toList());
    }
}