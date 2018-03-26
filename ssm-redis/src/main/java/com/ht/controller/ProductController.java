package com.ht.controller;

import com.ht.bean.Product;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("all")
    public List<Product> listAll() {
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product(1L, "iPhone 1X", "iPhone 1X", new BigDecimal(9999.0), new BigDecimal(999.99), "../../image/1.jpg"));
        productList.add(new Product(2L, "iPhone 2X", "iPhone 2X", new BigDecimal(9999.0), new BigDecimal(999.99), "../../image/2.jpg"));
        productList.add(new Product(3L, "iPhone 3X", "iPhone 3X", new BigDecimal(9999.0), new BigDecimal(999.99), "http://img02.tooopen.com/images/20150928/tooopen_sy_143912755726.jpg"));
        productList.add(new Product(4L, "iPhone 4X", "iPhone 4X", new BigDecimal(9999.0), new BigDecimal(999.99), "../../image/3.jpg"));
        productList.add(new Product(5L, "iPhone 5X", "iPhone 5X", new BigDecimal(9999.0), new BigDecimal(999.99), "../../image/4.jpg"));
        return productList;
    }

    @PostMapping("one/{id}")
    public Product getById(@PathVariable("id") Long id) {
        // 根据id查找商品信息
        System.out.println(id);
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product(1L, "iPhone 1X", "iPhone 1X", new BigDecimal(9999.0), new BigDecimal(999.99), "../../image/1.jpg"));
        productList.add(new Product(2L, "iPhone 2X", "iPhone 2X", new BigDecimal(9999.0), new BigDecimal(999.99), "../../image/2.jpg"));
        productList.add(new Product(3L, "iPhone 3X", "iPhone 3X", new BigDecimal(9999.0), new BigDecimal(999.99), "http://img02.tooopen.com/images/20150928/tooopen_sy_143912755726.jpg"));
        productList.add(new Product(4L, "iPhone 4X", "iPhone 4X", new BigDecimal(9999.0), new BigDecimal(999.99), "../../image/3.jpg"));
        productList.add(new Product(5L, "iPhone 5X", "iPhone 5X", new BigDecimal(9999.0), new BigDecimal(999.99), "../../image/4.jpg"));
        for (int i=0 ; i<productList.size();i++) {
            Product product = productList.get(i);
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

}
