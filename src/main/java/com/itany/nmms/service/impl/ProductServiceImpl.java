package com.itany.nmms.service.impl;

import com.itany.nmms.constant.DictConstant;
import com.itany.nmms.dao.ProductMapper;
import com.itany.nmms.dao.SequenceMapper;
import com.itany.nmms.entity.*;
import com.itany.nmms.exception.ProductExistException;
import com.itany.nmms.exception.RequestParameterErrorException;
import com.itany.nmms.service.ProductService;
import com.itany.nmms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private SequenceMapper sequenceMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void addProduct(String name, String price, MultipartFile file, String typeId, HttpSession session) throws RequestParameterErrorException, ProductExistException {
        if(StringUtil.isNull(name) || StringUtil.isNull(price) || file.isEmpty() || StringUtil.isNull(typeId)){
            throw new RequestParameterErrorException("请求参数有误");
        }
        ProductExample productExample = new ProductExample();
        productExample.or()
                .andNameEqualTo(name);
        List<Product> products = productMapper.selectByExample(productExample);
        if(!products.isEmpty()){
            throw new ProductExistException("该商品已经存在");
        }

        Product product = new Product();
        product.setName(name);
        product.setPrice(Double.parseDouble(price));
        product.setProductTypeId(Integer.parseInt(typeId));

        // 生成商品编号
        SequenceExample example = new SequenceExample();
        example.or()
                .andNameEqualTo(DictConstant.PRODUCT_NO_PREFIX);
        List<Sequence> sequences = sequenceMapper.selectByExample(example);
        if(sequences.isEmpty()){
            Sequence sequence = new Sequence();
            sequence.setName(DictConstant.PRODUCT_NO_PREFIX);
            sequence.setValue(DictConstant.PRODUCT_NO_SEQUENCE_INIT_VALUE);
            // 添加序列号
            sequenceMapper.insertSelective(sequence);

            // 生成对应的商品编号
            product.setProductNo(DictConstant.PRODUCT_NO_PREFIX+new SimpleDateFormat("yyyyMMdd").format(new Date())+sequence.getValue());
        }else{
            Sequence sequence = sequences.get(0);
            // 如果序列号的值达到了最大值
            // 则下一个值为初始值
            if(sequence.getValue() == DictConstant.PRODUCT_NO_SEQUENCE_MAX_VALUE){
                sequence.setValue(DictConstant.PRODUCT_NO_SEQUENCE_INIT_VALUE);
            }else{
                // 如果序列号尚未达到最大值
                // 则在原有基础上+1
                sequence.setValue(String.format("%06d",Integer.parseInt(sequence.getValue())+1));
            }
            // 修改序列号
            sequenceMapper.updateByPrimaryKeySelective(sequence);

            // 生成对应的商品编号
            product.setProductNo(DictConstant.PRODUCT_NO_PREFIX+new SimpleDateFormat("yyyyMMdd").format(new Date())+sequence.getValue());
        }

        // 文件上传
        String path = DictConstant.PRODUCT_IMAGE_ROOT_DIRECTORY+new SimpleDateFormat("yyyyMMdd").format(new Date());
        String cp = session.getServletContext().getRealPath(path);
        System.out.println("cp:"+cp);
        File f = new File(cp);
        f.mkdirs();


        try {
            product.setImage(path+"/"+file.getOriginalFilename());
            productMapper.insertSelective(product);
            // 上传
            file.transferTo(new File(cp,file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<Product> findAll() {
        return productMapper.selectAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Product findById(String id) throws RequestParameterErrorException {
        if(StringUtil.isNull(id)){
            throw new RequestParameterErrorException("请求参数有误");
        }
        Product product = productMapper.selectByPrimaryKey(Integer.parseInt(id));
        return product;
    }

    @Override
    public void modifyProduct(String productId,String name, String price, MultipartFile file, String typeId, HttpSession session) throws RequestParameterErrorException, ProductExistException {
        if(StringUtil.isNull(name) || StringUtil.isNull(price) || file.isEmpty() || StringUtil.isNull(typeId)){
            throw new RequestParameterErrorException("请求参数有误");
        }
        ProductExample productExample = new ProductExample();
        productExample.or()
                .andProductIdEqualTo(Integer.parseInt(productId));
        List<Product> products = productMapper.selectByExample(productExample);
        if(products.isEmpty()){
            throw new ProductExistException("该商品不存在");
        }

        ProductExample example = new ProductExample();
        example.createCriteria().andProductIdEqualTo(Integer.parseInt(productId));
        Product product = new Product();

        product.setProductId(Integer.parseInt(productId));
        product.setPrice(Double.parseDouble(price));
        product.setName(name);
        product.setProductTypeId(Integer.parseInt(typeId));

        String path = DictConstant.PRODUCT_IMAGE_ROOT_DIRECTORY+new SimpleDateFormat("yyyyMMdd").format(new Date());
        String cp = session.getServletContext().getRealPath(path);
        System.out.println("cp:"+cp);
        File f = new File(cp);
        f.mkdirs();

        try {
            product.setImage(path+"/"+file.getOriginalFilename());
            productMapper.updateByExampleSelective(product,example);
            // 上传
            file.transferTo(new File(cp,file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void remove(String id) throws RequestParameterErrorException, ProductExistException {
        if(StringUtil.isNull(id)){
            throw new RequestParameterErrorException("请求参数有误");
        }
        ProductExample productExample = new ProductExample();
        productExample.or()
                .andProductIdEqualTo(Integer.parseInt(id));
        List<Product> products = productMapper.selectByExample(productExample);
        if(products.isEmpty()){
            throw new ProductExistException("该商品不存存在");
        }
        productMapper.deleteByPrimaryKey(Integer.parseInt(id));
    }
}
