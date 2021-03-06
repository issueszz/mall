package com.example.mallmbg.mapper;

import com.example.mallmbg.model.SmsHomeRecommendSubject;
import com.example.mallmbg.model.SmsHomeRecommendSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsHomeRecommendSubjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_home_recommend_subject
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    long countByExample(SmsHomeRecommendSubjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_home_recommend_subject
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int deleteByExample(SmsHomeRecommendSubjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_home_recommend_subject
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_home_recommend_subject
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int insert(SmsHomeRecommendSubject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_home_recommend_subject
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int insertSelective(SmsHomeRecommendSubject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_home_recommend_subject
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    List<SmsHomeRecommendSubject> selectByExample(SmsHomeRecommendSubjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_home_recommend_subject
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    SmsHomeRecommendSubject selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_home_recommend_subject
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int updateByExampleSelective(@Param("record") SmsHomeRecommendSubject record, @Param("example") SmsHomeRecommendSubjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_home_recommend_subject
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int updateByExample(@Param("record") SmsHomeRecommendSubject record, @Param("example") SmsHomeRecommendSubjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_home_recommend_subject
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int updateByPrimaryKeySelective(SmsHomeRecommendSubject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_home_recommend_subject
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int updateByPrimaryKey(SmsHomeRecommendSubject record);
}