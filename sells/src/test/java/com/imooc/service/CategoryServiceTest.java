package com.imooc.service;

import com.imooc.dataobject.ProductCategory;
import com.imooc.service.impl.CategoryServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
       ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategories = categoryService.findAll();
        System.out.println("size  :"+productCategories.size());
        Assert.assertNotEquals(0, productCategories.size());
    }

    @Test
    public void findByCategoryTypeIn() {
       List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(Arrays.asList(1001,1002));
        Assert.assertNotEquals(0,productCategories.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("男生专享",1003);
        ProductCategory result = categoryService.save(productCategory);
        System.out.println(result);
        Assert.assertNotNull(result);
    }
}