package com.example.session_1.BeanWiring;

import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService{
    @Override
    public boolean checkStock(String productId, int quantity) {
        System.out.println("Checking stock for " + productId);
        return true;
    }
}
