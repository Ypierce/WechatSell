package com.peirce.service;

import com.peirce.entity.SellerInfo;


public interface SellerService {

    SellerInfo findSellerInfoByOpenid(String openid);
}
