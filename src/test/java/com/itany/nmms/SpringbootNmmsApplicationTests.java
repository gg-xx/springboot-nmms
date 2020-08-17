package com.itany.nmms;

import com.itany.nmms.constant.StatusConstant;
import com.itany.nmms.dao.DeptMapper;
import com.itany.nmms.dao.ProductTypeMapper;
import com.itany.nmms.entity.Dept;
import com.itany.nmms.entity.ProductType;
import com.itany.nmms.entity.ProductTypeExample;
import com.itany.nmms.service.ProductTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootNmmsApplicationTests {
    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private ProductTypeMapper typeMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void testDept(){
        List<Dept> all = deptMapper.findAll();
        System.out.println(all);
    }
    @Test
    public void testDept3(){
        System.out.println("all");
    }

    @Test
    void contextLoads() {
        List<ProductType> enable = productTypeService.findEnable();
        System.out.println(enable);
        ProductTypeExample example = new ProductTypeExample();
        example.or()
                .andStatusEqualTo(StatusConstant.SYS_PRODUCT_TYPE_STATUS_ENABLE);
        List<ProductType> types = typeMapper.selectByExample(example);
        System.out.println(types);
    }

}
