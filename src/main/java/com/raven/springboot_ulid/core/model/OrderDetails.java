package com.raven.springboot_ulid.core.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.raven.springboot_ulid.common.model.Ulid;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails {
    @Id
    @Ulid
    @Column(name = "ID", unique = true, nullable = false, length = 26)
    private String id;

    @Column(name = "item_id", length = 40)
    private String itemId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_master_id", referencedColumnName = "ID", nullable = false)
    private OrderMaster orderMaster;

    public String getId() {
        return id;
    }

    public OrderDetails setId(String id) {
        this.id = id;
        return this;
    }

    public String getItemId() {
        return itemId;
    }

    public OrderDetails setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderDetails setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public OrderDetails setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public OrderMaster getOrderMaster() {
        return orderMaster;
    }

    public OrderDetails setOrderMaster(OrderMaster orderMaster) {
        this.orderMaster = orderMaster;
        return this;
    }
}
