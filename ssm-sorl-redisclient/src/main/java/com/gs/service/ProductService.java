package com.gs.service;

import com.gs.bean.ResultModel;

public interface ProductService {
	public ResultModel getProducts(String queryString, String catalogName,
                                   String price, String sort, Integer page) throws Exception;
}
