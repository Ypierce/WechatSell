package com.peirce.controller;

import com.peirce.service.SeckillService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeckillController {

    @Autowired
    private  SeckillService seckillService;

    @GetMapping("/sell/{productId}")
    public String querySeckillProductInfo(@PathVariable("productId") String productId ){
        return seckillService.querySeckillProductInfo(productId);
    }

    @GetMapping("/order/{productId}")
    public String orderSeckillProductInfo(@PathVariable("productId") String productId ){
        seckillService.orderProductMockDiffUser(productId);
        return seckillService.querySeckillProductInfo(productId);
    }

}
