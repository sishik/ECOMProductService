package com.ecommerce.ProductService.mapper;

import com.ecommerce.ProductService.dtos.FakeStoreProductRequestDto;
import com.ecommerce.ProductService.dtos.FakeStoreProductResponseDto;
import com.ecommerce.ProductService.dtos.ProductRequestDto;
import com.ecommerce.ProductService.dtos.ProductResponseDto;

public class ProductMapper {
    public static FakeStoreProductRequestDto productRequestToFakeStoreProductRequest(ProductRequestDto productRequestDto){
        FakeStoreProductRequestDto fakeStoreProductRequestDTO = new FakeStoreProductRequestDto();
        fakeStoreProductRequestDTO.setCategory(productRequestDto.getCategory());
        fakeStoreProductRequestDTO.setDescription(productRequestDto.getDescription());
        fakeStoreProductRequestDTO.setPrice(productRequestDto.getPrice());
        fakeStoreProductRequestDTO.setImage(productRequestDto.getImage());
        fakeStoreProductRequestDTO.setTitle(productRequestDto.getTitle());
        return fakeStoreProductRequestDTO;
    }

    public static ProductResponseDto fakeProductResponseToProductResponse(FakeStoreProductResponseDto fakeStoreProductResponseDTO){
        ProductResponseDto productResponseDTO = new ProductResponseDto();
        productResponseDTO.setId(fakeStoreProductResponseDTO.getId());
        productResponseDTO.setPrice(fakeStoreProductResponseDTO.getPrice());
        productResponseDTO.setTitle(fakeStoreProductResponseDTO.getTitle());
        productResponseDTO.setDescription(fakeStoreProductResponseDTO.getDescription());
        productResponseDTO.setCategory(fakeStoreProductResponseDTO.getCategory());
        productResponseDTO.setImage(fakeStoreProductResponseDTO.getImage());
        return productResponseDTO;
    }
}
