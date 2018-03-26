package com.gs.controller;

import com.gs.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gs.bean.ResultModel;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;

	@RequestMapping("/list")
	public String list(String queryString, String catalog_name, String price,
			String sort, Integer page, Model model) throws Exception {
		System.out.println("进来了     ："+queryString+"  "+catalog_name+"   "+price+"  "+sort+"   "+page);
		ResultModel rm = service.getProducts(queryString, catalog_name, price,
				sort, page);
		
		// 将查询结果放到request域
		model.addAttribute("result", rm);

		// 简单类型的数据回显
		model.addAttribute("queryString", queryString);
		model.addAttribute("catalog_name", catalog_name);
		model.addAttribute("price", price);
		model.addAttribute("sort", sort);
		model.addAttribute("page", page);

		return "product_list";
	}
	
	@RequestMapping("/add")
	public String add(){
		System.out.println("kkkkk");
		return null;
	}
}
