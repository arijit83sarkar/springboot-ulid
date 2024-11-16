package com.raven.springboot_ulid.core.service;

import com.raven.springboot_ulid.core.model.OrderDetails;
import com.raven.springboot_ulid.core.model.OrderMaster;
import com.raven.springboot_ulid.core.model.dto.OrderMasterInput;
import com.raven.springboot_ulid.core.repository.IOrderMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderMasterService {
    private final IOrderMasterRepository orderMasterRepository;

    @Autowired
    public OrderMasterService(IOrderMasterRepository orderMasterRepository) {
        this.orderMasterRepository = orderMasterRepository;
    }

    public OrderMaster saveOrder(OrderMasterInput input) {
        List<OrderDetails> orderDetails = new ArrayList<>();

        if (input.detailsInputs().isPresent()) {
            orderDetails = input.detailsInputs().get()
                    .stream()
                    .map(e -> new OrderDetails()
                            .setItemId(e.itemId())
                            .setQuantity(e.quantity())
                            .setUnitPrice(e.unitPrice())
                    ).toList();
        }

        OrderMaster orderMaster = new OrderMaster()
                .setOrderDate(input.orderDate())
                .setCustomerId(input.customerId())
                .setOrderDetails(orderDetails);

        orderMaster = this.orderMasterRepository.save(orderMaster);
        return orderMaster;
    }

    public OrderMaster getDetails(String id) {
        Optional<OrderMaster> orderMaster = orderMasterRepository.findById(id);
        if (orderMaster.isPresent()) {
            return orderMaster.get();
        } else {
            return null;
        }
    }
}
