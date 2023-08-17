package com.teknopar.northwind.api.controllers;

import com.teknopar.northwind.core.utilities.results.DataResult;
import com.teknopar.northwind.core.utilities.results.Result;
import com.teknopar.northwind.model.concretes.Product;
import com.teknopar.northwind.model.dtos.ProductWithCategoryDto;
import com.teknopar.northwind.service.abstracts.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductsController {
    private ProductService productService;
    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
        return this.productService.getALl();
    }
    @GetMapping("/getAllDesc")
    public DataResult<List<Product>> getALlSorted(){
        return this.productService.getALlSorted();
    }
    @GetMapping("/getALlByPage")
    public DataResult<List<Product>> getALl(int pageNo, int pageSize) {
        return this.productService.getALl(pageNo,pageSize);
    }
    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }
    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam("productName") String productName) {
        return this.productService.getByProductName(productName);
    }
    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
        return this.productService.getByProductNameAndCategoryId(productName,categoryId);
    }
    @GetMapping("/getByProductNameOrCategoryId")
    DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam String productName,@RequestParam int categoryId){
        return this.productService.getByProductNameOrCategoryId(productName,categoryId);
    }
    @GetMapping("/getByCategoryIdIn")
    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories){
        return this.productService.getByCategoryIdIn(categories);
    }
    @GetMapping("/getByProductNameContains")
    DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
    }
    @GetMapping("/getByProductNameStartsWith")
    DataResult<List<Product>> getByProductNameStartsWith(String productName){
        return this.productService.getByProductNameStartsWith(productName);
    }
    @GetMapping("/getByNameAndCategory")
    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return this.productService.getByNameAndCategory(productName, categoryId);
    }
    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
        return this.productService.getProductWithCategoryDetails();
    }
}
