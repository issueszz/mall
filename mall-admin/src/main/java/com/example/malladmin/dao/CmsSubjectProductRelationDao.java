package com.example.malladmin.dao;

import com.example.mallmbg.model.CmsSubjectProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsSubjectProductRelationDao {
    int insertList(@Param("list") List<CmsSubjectProductRelation> subjectProductRelationList);
}
