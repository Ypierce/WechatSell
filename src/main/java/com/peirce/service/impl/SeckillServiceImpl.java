package com.peirce.service.impl;

import com.peirce.expection.SellException;
import com.peirce.service.RedisLock;
import com.peirce.service.SeckillService;
import com.peirce.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SeckillServiceImpl implements SeckillService {

    private static final int expireTime = 10*1000;

    private static Map<String,Integer> products;
    private static Map<String,Integer> stock;
    private static Map<String,String> orders;

    static {
        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();
        products.put("123456",10000);
        stock.put("123456",10000);
    }
    private String queryMap(String productId){
        return "国庆活动，皮蛋粥特价，限量份"
                + products.get(productId)
                +"还剩："+ stock.get(productId)
                +"改商品成功下单用户数目:"
                + orders.size()+"人";
    }

    @Autowired
    private RedisLock redisLock;

    @Override
    public String querySeckillProductInfo(String productId) {
        return this.queryMap(productId);
    }

    @Override
    public void orderProductMockDiffUser(String productId) {

        long currentValue = System.currentTimeMillis() + expireTime;
        if(!redisLock.lock(productId,String.valueOf(currentValue))){
            throw new SellException(101,"换个姿势再试试");
        }
        //1.查询商品
        int stockNum = stock.get(productId);
        if(stockNum == 0){
            throw new SellException(100,"活动结束");
        }else{
            orders.put(KeyUtil.genUniqueKey(),productId);
            stockNum = stockNum -1;
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            stock.put(productId,stockNum);
        }

        redisLock.unlock(productId,String.valueOf(currentValue));
    }
}
