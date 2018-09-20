package com.wechat.sell.controller;

import com.wechat.sell.VO.ProductInfoVO;
import com.wechat.sell.VO.ProductVO;
import com.wechat.sell.VO.ResultVO;
import com.wechat.sell.entity.ProductCategory;
import com.wechat.sell.entity.ProductInfo;
import com.wechat.sell.enums.ProductStatusEnum;
import com.wechat.sell.service.ProductCategoryService;
import com.wechat.sell.service.ProductInfoService;
import com.wechat.sell.utils.ResultVOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class ProductController {
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping("/list")
    public ResultVO list(){
        //1.查询上架的数据
        List<ProductInfo> productInfoList = productInfoService.findByProductStatus();
        //2.查询类目（一次性查询）
        List<Integer> categoryTypeList = productInfoList
                .stream().map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory :productCategoryList){

            ProductVO productVO = new ProductVO();
            productVO.setProductCategoryName(productCategory.getCategoryName());
            productVO.setProductCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //將productInfo的值拷贝到productInfoVO中
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVO(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtils.success(productVOList);
    }
}
