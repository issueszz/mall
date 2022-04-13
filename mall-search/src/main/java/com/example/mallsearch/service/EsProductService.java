package com.example.mallsearch.service;

import com.example.mallsearch.domain.EsProduct;
import org.springframework.data.domain.Page;

public interface EsProductService {
    int importAll();
    Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);
}
