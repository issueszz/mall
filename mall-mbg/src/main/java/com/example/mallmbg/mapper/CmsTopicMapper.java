package com.example.mallmbg.mapper;

import com.example.mallmbg.model.CmsTopic;
import com.example.mallmbg.model.CmsTopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsTopicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_topic
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    long countByExample(CmsTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_topic
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int deleteByExample(CmsTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_topic
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_topic
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int insert(CmsTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_topic
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int insertSelective(CmsTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_topic
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    List<CmsTopic> selectByExampleWithBLOBs(CmsTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_topic
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    List<CmsTopic> selectByExample(CmsTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_topic
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    CmsTopic selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_topic
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int updateByExampleSelective(@Param("record") CmsTopic record, @Param("example") CmsTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_topic
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("record") CmsTopic record, @Param("example") CmsTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_topic
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int updateByExample(@Param("record") CmsTopic record, @Param("example") CmsTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_topic
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int updateByPrimaryKeySelective(CmsTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_topic
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(CmsTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_topic
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int updateByPrimaryKey(CmsTopic record);
}