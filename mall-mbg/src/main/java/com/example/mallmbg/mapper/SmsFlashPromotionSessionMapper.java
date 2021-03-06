package com.example.mallmbg.mapper;

import com.example.mallmbg.model.SmsFlashPromotionSession;
import com.example.mallmbg.model.SmsFlashPromotionSessionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsFlashPromotionSessionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    long countByExample(SmsFlashPromotionSessionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int deleteByExample(SmsFlashPromotionSessionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int insert(SmsFlashPromotionSession record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int insertSelective(SmsFlashPromotionSession record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    List<SmsFlashPromotionSession> selectByExample(SmsFlashPromotionSessionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    SmsFlashPromotionSession selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int updateByExampleSelective(@Param("record") SmsFlashPromotionSession record, @Param("example") SmsFlashPromotionSessionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int updateByExample(@Param("record") SmsFlashPromotionSession record, @Param("example") SmsFlashPromotionSessionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int updateByPrimaryKeySelective(SmsFlashPromotionSession record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated Wed Feb 23 16:48:48 CST 2022
     */
    int updateByPrimaryKey(SmsFlashPromotionSession record);
}