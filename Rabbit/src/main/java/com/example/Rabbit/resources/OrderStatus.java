package com.example.Rabbit.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderStatus {
    private PurchaseOrder purchaseOrder;
    private String status;
    private String message;

}
