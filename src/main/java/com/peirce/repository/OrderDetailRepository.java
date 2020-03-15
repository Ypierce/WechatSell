package com.peirce.repository;

import com.peirce.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.soap.Detail;
import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String>{
    List<OrderDetail> findByOrderId(String orderId);
}

