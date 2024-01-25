package com.ecommerce.ProductService.services;

import com.ecommerce.ProductService.client.FakeStoreAPIClient;
import com.ecommerce.ProductService.dtos.*;
import com.ecommerce.ProductService.exception.ProductNotFoundException;
import com.ecommerce.ProductService.mapper.ProductMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static com.ecommerce.ProductService.mapper.ProductMapper.*;
import static com.ecommerce.ProductService.util.ProductUtils.isNull;

@Service
public class FakeStoreServiceImpl implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreAPIClient fakeStoreAPIClient;


    public FakeStoreServiceImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreAPIClient fakeStoreAPIClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    @Override
    public ProductListResponseDto getAllProducts() {
        List<FakeStoreProductResponseDto>fakeStoreProductResponseDtos = fakeStoreAPIClient.getAllProducts();
        ProductListResponseDto productListResponseDto = new ProductListResponseDto();
        for(FakeStoreProductResponseDto responseDto:fakeStoreProductResponseDtos){
            productListResponseDto.getProducts().add(fakeProductResponseToProductResponse(responseDto));
        }
        return productListResponseDto;
    }

    @Override
    public ProductResponseDto getProductById(int id)throws ProductNotFoundException {
        FakeStoreProductResponseDto fakeStoreProductResponseDto = fakeStoreAPIClient.getProductById(id);
        if(isNull(fakeStoreProductResponseDto)){
            throw new ProductNotFoundException("product doesn't exist for "+ id);
        }
        return fakeProductResponseToProductResponse(fakeStoreProductResponseDto);
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        FakeStoreProductRequestDto fakeStoreProductRequestDto = productRequestToFakeStoreProductRequest(productRequestDto);
        FakeStoreProductResponseDto fakeStoreProductResponseDto = fakeStoreAPIClient.createProduct(fakeStoreProductRequestDto);
        return fakeProductResponseToProductResponse(fakeStoreProductResponseDto);
    }
}
