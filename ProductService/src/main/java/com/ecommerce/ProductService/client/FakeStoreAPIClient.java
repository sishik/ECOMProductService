package com.ecommerce.ProductService.client;

import com.ecommerce.ProductService.dtos.FakeStoreProductRequestDto;
import com.ecommerce.ProductService.dtos.FakeStoreProductResponseDto;
import com.ecommerce.ProductService.dtos.ProductListResponseDto;
import com.ecommerce.ProductService.dtos.ProductResponseDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Component
public class FakeStoreAPIClient {
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    public List<FakeStoreProductResponseDto>getAllProducts(){
        String getAllProductsUrl = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDto[]>productResponseArray=
                restTemplate.getForEntity(getAllProductsUrl, FakeStoreProductResponseDto[].class);
        return List.of(productResponseArray.getBody());

    }
    public FakeStoreProductResponseDto createProduct(FakeStoreProductRequestDto fakeStoreProductRequestDto){
        String createProductsUrl = "https://fakestoreapi.com/products/";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDto>fakeStoreProductResponseDto = restTemplate.postForEntity(createProductsUrl,fakeStoreProductRequestDto, FakeStoreProductResponseDto.class);
        return fakeStoreProductResponseDto.getBody();
    }
    public FakeStoreProductResponseDto getProductById(int id){
        String getProductsUrl = "https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDto>response=restTemplate.getForEntity(getProductsUrl,FakeStoreProductResponseDto.class);
        return response.getBody();
    }
}
/*whenever we call 3rd part Api just like adaptor we need to create client for 3rd party api.
so, Instead of calling the 3rd part api from services. we will call client of 3rd party api from services.
this is the best practice.
 */
