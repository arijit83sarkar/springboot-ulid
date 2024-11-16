package com.raven.springboot_ulid.core.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.raven.springboot_ulid.common.model.Uuid;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ORDER_MASTER")
public class OrderMaster {
    @Id
    @Uuid
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "customer_id", length = 40)
    private String customerId;

    @Column(name = "order_posted_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime orderPostedDate;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "orderMaster")
    private List<OrderDetails> orderDetails;

    public String getId() {
        return id;
    }

    public OrderMaster setId(String id) {
        this.id = id;
        return this;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public OrderMaster setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public String getCustomerId() {
        return customerId;
    }

    public OrderMaster setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public LocalDateTime getOrderPostedDate() {
        return orderPostedDate;
    }

    public OrderMaster setOrderPostedDate(LocalDateTime orderPostedDate) {
        this.orderPostedDate = orderPostedDate;
        return this;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public OrderMaster setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails
                .stream()
                .map(o -> o.setOrderMaster(this))
                .toList();
        return this;
    }
}
