package com.itany.nmms.controller;

import com.itany.nmms.entity.Product;
import com.itany.nmms.service.ProductService2;
import com.itany.nmms.util.FrameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product2")
public class ProductController2 {

    @Autowired
    private ProductService2 productService;

    @PostMapping("/addProduct")
    public FrameResponse addProduct(Product product){
        int result = productService.addProduct(product);
        System.out.println(product);
        if(result>0)
            return FrameResponse.success("添加成功");
        return FrameResponse.failure("添加失败");
    }

    @GetMapping("/findAll")
    public FrameResponse findAll(){
        List<Product> productList = productService.findAll();
        return FrameResponse.success(productList);
    }

    @GetMapping("/delProductByPrimaryKey")
    public FrameResponse delProductByPrimaryKey(int id){
        int result = productService.delProductByPrimaryKey(id);
        System.out.println(result);
        if (result>0)
            FrameResponse.success("删除成功");
        return FrameResponse.failure("删除失败");
    }

    @PostMapping("/alterSelectByPrimaryKey")
    public FrameResponse alterSelectByPrimaryKey(Product product){
        System.out.println(product);
        int result = productService.alterSelectByPrimaryKey(product);
        if(result>0)
            return FrameResponse.success("修改成功");
        return FrameResponse.failure("修改失败");
    }

}
