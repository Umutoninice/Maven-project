package com.example.session_1.BeanWiring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class OrderServiceTest  {
@Mock
    private InventoryService inventoryService;
@Mock
    private NotificationService notificationService;

private OrderService orderService;

@BeforeEach
    void setUp(){
    MockitoAnnotations.openMocks(this);
    orderService = new OrderService(inventoryService,notificationService);
}
@Test
    void placeOrder_checkStockBeforeNotifying(){
    when(inventoryService.checkStock("P01", 3)).thenReturn(true);
    boolean result = orderService.placeOrder("P01",3);
    assertTrue(result);

    verify(inventoryService).checkStock("P01",3);
    verify(notificationService).notify(anyString());

    // confirm the order they were called in
    InOrder inOrder= inOrder(inventoryService,notificationService);
    inOrder.verify(inventoryService).checkStock("P01",3);
    inOrder.verify(notificationService).notify(anyString());

}
@Test
    void placeOrder_outOfStock_stillNotifiesAfterCheckingStock(){
    when(inventoryService.checkStock("P01", 5)).thenReturn(false);
    boolean result = orderService.placeOrder("P01",5);
    assertTrue(!result);
    // confirm the order they were called in
    InOrder inOrder = inOrder(inventoryService,notificationService);
    inOrder.verify(inventoryService).checkStock("P01",5);
    inOrder.verify(notificationService).notify(contains("out of stock"));
}
}