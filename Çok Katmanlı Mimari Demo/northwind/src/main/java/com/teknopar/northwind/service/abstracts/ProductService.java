package com.teknopar.northwind.service.abstracts;

import com.teknopar.northwind.core.utilities.results.DataResult;
import com.teknopar.northwind.core.utilities.results.Result;
import com.teknopar.northwind.model.concretes.Product;
import com.teknopar.northwind.model.dtos.ProductWithCategoryDto;

import java.util.List;

public interface ProductService {
     DataResult<List<Product>> getALl();
     DataResult<List<Product>> getALlSorted();
     DataResult<List<Product>> getALl(int pageNo,int pageSize);
     Result add(Product product);

     DataResult<Product> getByProductName(String productName);

     DataResult<Product> getByProductNameAndCategoryId(String productName,int categoryId);

     DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

     DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);


     DataResult<List<Product>> getByProductNameContains(String productName);

     DataResult<List<Product>> getByProductNameStartsWith(String productName);

     DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
     DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

}
