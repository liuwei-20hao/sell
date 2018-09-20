package com.wechat.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class ProductVO {
    @JsonProperty("name")
    private String productCategoryName;
    @JsonProperty("type")
    private Integer productCategoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVO;
}
