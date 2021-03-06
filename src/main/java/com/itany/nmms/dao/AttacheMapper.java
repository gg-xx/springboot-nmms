package com.itany.nmms.dao;

import com.itany.nmms.entity.Attache;
import com.itany.nmms.entity.AttacheExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttacheMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_attache
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    int countByExample(AttacheExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_attache
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    int deleteByExample(AttacheExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_attache
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    int deleteByPrimaryKey(Integer attacheId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_attache
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    int insert(Attache record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_attache
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    int insertSelective(Attache record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_attache
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    List<Attache> selectByExample(AttacheExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_attache
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    Attache selectByPrimaryKey(Integer attacheId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_attache
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    int updateByExampleSelective(@Param("record") Attache record, @Param("example") AttacheExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_attache
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    int updateByExample(@Param("record") Attache record, @Param("example") AttacheExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_attache
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    int updateByPrimaryKeySelective(Attache record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_attache
     *
     * @mbggenerated Sat Aug 01 09:00:59 CST 2020
     */
    int updateByPrimaryKey(Attache record);
}