package com.itany.nmms.service;

import com.itany.nmms.entity.Product;
import com.itany.nmms.entity.ProductType;
import com.itany.nmms.exception.ProductExistException;
import com.itany.nmms.exception.RequestParameterErrorException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ProductService {

    /**
     * 添加商品
     * @param name
     * @param price
     * @param file
     * @param typeId
     */
    public void addProduct(String name, String price, MultipartFile file, String typeId, HttpSession session) throws RequestParameterErrorException, ProductExistException;

    public List<Product> findAll();

    public Product findById(String id) throws RequestParameterErrorException;

    public void modifyProduct(String productId,String name, String price, MultipartFile file, String typeId, HttpSession session) throws RequestParameterErrorException, ProductExistException;

    public void remove(String id) throws RequestParameterErrorException, ProductExistException;
}
