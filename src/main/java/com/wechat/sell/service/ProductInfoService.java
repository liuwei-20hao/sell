package com.wechat.sell.service;



import com.wechat.sell.dto.CartDTO;
import com.wechat.sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ProductInfoService {
    ProductInfo findOne(String  productId);

    Page<ProductInfo> findAll(Pageable pageable);

    List<ProductInfo> findByProductStatus();

    void save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo offSale(String productId);
}
