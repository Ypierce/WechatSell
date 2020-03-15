package com.peirce.repository;

import com.peirce.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

   @Autowired
   private ProductCategoryRepository repository;

   @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
   }

   @Test
   @Transactional
    public void saveTest(){
       ProductCategory productCategory = new ProductCategory();
       productCategory.setCategoryId(5);
       productCategory.setCategoryName("生最爱");
       productCategory.setCategoryType(5);
       repository.save(productCategory);
       Assert.assertNotNull(productCategory);
   }


}
