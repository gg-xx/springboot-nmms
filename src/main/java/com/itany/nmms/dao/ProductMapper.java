package com.itany.nmms.dao;

import com.itany.nmms.entity.Product;
import com.itany.nmms.entity.ProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_product
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    int countByExample(ProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_product
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    int deleteByExample(ProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_product
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    int deleteByPrimaryKey(Integer productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_product
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    int insert(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_product
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    int insertSelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_product
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    List<Product> selectByExample(ProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_product
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    Product selectByPrimaryKey(Integer productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_product
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_product
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_product
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    int updateByPrimaryKeySelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_product
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    int updateByPrimaryKey(Product record);

    List<Product> selectAll();
}