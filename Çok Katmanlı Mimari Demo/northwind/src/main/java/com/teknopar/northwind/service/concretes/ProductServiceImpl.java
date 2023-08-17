package com.teknopar.northwind.service.concretes;

import com.teknopar.northwind.core.utilities.results.DataResult;
import com.teknopar.northwind.core.utilities.results.Result;
import com.teknopar.northwind.core.utilities.results.SuccesResult;
import com.teknopar.northwind.core.utilities.results.SuccessDataResult;
import com.teknopar.northwind.model.concretes.Product;
import com.teknopar.northwind.model.dtos.ProductWithCategoryDto;
import com.teknopar.northwind.repository.abstracts.ProductDao;
import com.teknopar.northwind.service.abstracts.ProductService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;
    @Override
    public DataResult<List<Product>> getALl() {
        return new SuccessDataResult<List<Product>>(productDao.findAll(),"Data Listelendi");
    }
    @Override
    public DataResult<List<Product>> getALlSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"productName");
        return new SuccessDataResult<List<Product>>(productDao.findAll(sort),"Başarılı");
    }
    @Override
    public DataResult<List<Product>> getALl(int pageNo, int pageSize) {
        Pageable pageable =  PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
    }
    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccesResult("Ürün Eklendi");
    }
    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(productDao.getByProductName(productName),"Data Listelendi");
    }
    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>(productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data Listelendi");
    }
    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Data Listelendi");
    }
    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(productDao.getByCategoryIn(categories),"Data Listelendi");
    }
    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(productDao.getByProductNameContains(productName), "Data Listelendi");
    }
    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(productDao.getByProductNameStartsWith(productName),"Data Listelendi");
    }
    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(productDao.getByNameAndCategory(productName,categoryId),"Data Listelendi");
    }
    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(),"Data listelendi");
    }
}
