package com.raven.springboot_ulid.core.controller;

import com.raven.springboot_ulid.common.model.AppApiResponse;
import com.raven.springboot_ulid.core.model.OrderMaster;
import com.raven.springboot_ulid.core.model.dto.OrderMasterInput;
import com.raven.springboot_ulid.core.service.OrderMasterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(description = "API related to Order.", name = "Order")
@RequestMapping("/order")
public class OrderController {
    private final OrderMasterService orderMasterService;

    @Autowired
    public OrderController(OrderMasterService orderMasterService) {
        this.orderMasterService = orderMasterService;
    }

    @Operation(summary = "Save a new Order.", description = "Save a new Order details.")
    @PostMapping(value = "/v1")
    public ResponseEntity<AppApiResponse<OrderMaster>> saveOrder(@RequestBody OrderMasterInput input) {
        return new ResponseEntity<>(new AppApiResponse<>("SUCCESS", orderMasterService.saveOrder(input), "Data saved!"),
                HttpStatus.OK);
    }

    @Operation(summary = "Get a Order details.", description = "Get a Order details by ID.")
    @RequestMapping(value = "/v1", method = RequestMethod.GET)
    public ResponseEntity<AppApiResponse<OrderMaster>> getDetails(@RequestParam String id) {
        return new ResponseEntity<>(new AppApiResponse<>("SUCCESS", orderMasterService.getDetails(id), "Data fetched!"),
                HttpStatus.OK);
    }
}
