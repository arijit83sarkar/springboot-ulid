package com.raven.springboot_ulid.core.repository;

import com.raven.springboot_ulid.core.model.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
