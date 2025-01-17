package com.vivek.productservice.Services;

import com.vivek.productservice.DTOS.FakeStoreProductDto;
import com.vivek.productservice.Exceptions.ProductNotFoundException;
import com.vivek.productservice.Exceptions.ProductNotFoundException;
import com.vivek.productservice.Models.Category;
import com.vivek.productservice.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    @Override
    public Product getProductById(Long id) {
        //Call the fake Store API to get the Product with tbe given ID
//        int x = 1/0;
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
//        throw new RuntimeException("Something went wrong in service");
        //Convert FakeStoreDto object to Product Object
        if (fakeStoreProductDto == null){
            throw new ProductNotFoundException(id,"Please Pass A valid Product ID");
        }

        return convertFakeStoreProductDtotoProduct(fakeStoreProductDto);
    }

    private Product convertFakeStoreProductDtotoProduct(FakeStoreProductDto fakeStoreProductDto){
            Product product = new Product();
            product.setId(fakeStoreProductDto.getId());
            product.setDescription(fakeStoreProductDto.getDescription());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setPrice(fakeStoreProductDto.getPrice());
            Category category = new Category();
            category.setDescription(fakeStoreProductDto.getCategory());
            product.setCategory(category);
            product.setImage(fakeStoreProductDto.getImage());
            return product;
    }
    public List<Product> getAllProducts(){
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto [] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products",FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        assert fakeStoreProductDtos != null;
        for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtos){
            products.add(convertFakeStoreProductDtotoProduct(fakeStoreProductDto));
        }
        return products;
    }
}
