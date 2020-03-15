package com.peirce.service;

import com.peirce.dto.OrderDTO;
import com.peirce.entity.SellerInfo;

public interface BuyerService {

    OrderDTO findOrderOne(String openid,String orderId);

    OrderDTO cancelOrder(String openid,String orderId);

}
