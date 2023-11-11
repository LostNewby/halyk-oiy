package kz.demo.halykoiy.controllers;

import jakarta.servlet.http.HttpServletRequest;
import kz.demo.halykoiy.entities.Role;
import kz.demo.halykoiy.entities.User;
import kz.demo.halykoiy.models.IncomeInfoDto;
import kz.demo.halykoiy.models.InventoryDto;
import kz.demo.halykoiy.models.ItemDto;
import kz.demo.halykoiy.models.LocationDto;
import kz.demo.halykoiy.services.IncomeInfoService;
import kz.demo.halykoiy.services.InventoryService;
import kz.demo.halykoiy.services.ItemService;
import kz.demo.halykoiy.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApplicationController {
    private final UserService userService; // Service layer to handle the logic
    private final ItemService itemService; // Service layer to handle item logic
    private final InventoryService inventoryService; // Service layer to handle inventory logic
    private final IncomeInfoService incomeInfoService; // Service layer to handle IncomeInfo logic

    // Set user role
    @PostMapping("/users/role")
    public ResponseEntity<?> setUserRole(@RequestBody String role, HttpServletRequest request) {
        userService.setRole(getUserFromRequest(request), Role.valueOf(role)); // Make sure to handle exceptions such as IllegalArgumentException
        return ResponseEntity.ok().build();
    }

    // Set Latitude and Longitude
    @PostMapping("/users/location")
    public ResponseEntity<?> setUserLocation(@RequestBody LocationDto locationDTO, HttpServletRequest request) {
        userService.setLocation(getUserFromRequest(request), locationDTO.getLatitude(), locationDTO.getLongitude());
        return ResponseEntity.ok().build();
    }

    // Add a new item
    @PostMapping("/items")
    public ResponseEntity<ItemDto> addItem(@RequestBody ItemDto itemDTO) {
        ItemDto createdItem = itemService.createItem(itemDTO);
        return ResponseEntity.ok(createdItem);
    }

    // Get the list of items
    @GetMapping("/items")
    public ResponseEntity<List<ItemDto>> getAllItems() {
        List<ItemDto> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @PostMapping("/inventory")
    public ResponseEntity<?> addInventory(@RequestBody InventoryDto inventoryDTO, HttpServletRequest request) {
        inventoryService.addInventory(getUserFromRequest(request), inventoryDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/inventory")
    public List<InventoryDto> getMyInventory(HttpServletRequest request) {
        return inventoryService.getMyInventory(getUserFromRequest(request));
    }

    // Set IncomeInfo
    @PostMapping("/incomeinfo")
    public ResponseEntity<?> setIncomeInfo(@RequestBody IncomeInfoDto incomeInfoDTO) {
        User user = userService.getUserByPhone("7754351960");
        incomeInfoService.setIncomeInfo(user, incomeInfoDTO);
        return ResponseEntity.ok().build();
    }

    private User getUserFromRequest(HttpServletRequest request) {
        return userService.getUserByPhone(request.getUserPrincipal().getName());
    }
}
