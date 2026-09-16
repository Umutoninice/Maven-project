package com.example.session_1.BeanWiring;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
private final InventoryService inventoryService;
private final NotificationService notificationService;

    public OrderService(InventoryService inventoryService, NotificationService notificationService) {
        this.inventoryService = inventoryService;
        this.notificationService = notificationService;
    }
    public boolean placeOrder(String productId, int quantity){
        boolean inStock = inventoryService.checkStock(productId, quantity);
        if(!inStock){
            notificationService.notify("Order failed: " + productId + " is out of stock.");
            return false;
        }
        notificationService.notify("Order placed successfully for " + productId);
        return true;
    }
}
