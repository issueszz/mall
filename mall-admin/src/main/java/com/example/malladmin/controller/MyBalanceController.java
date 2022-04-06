package com.example.malladmin.controller;

import com.example.malladmin.dto.BalanceDto;
import com.example.mallcommon.api.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/balance")
public class MyBalanceController {
    @GetMapping("/test")
    public CommonResult<List<BalanceDto>> test() {
        List<BalanceDto> balanceDtos = new ArrayList<>();
        try {
            // TODO: py脚本地址
            String pyPath = "/Users/zhouzhangbin/IdeaProjects/mall/document/balance.py";
            String[] args = new String[]{"python", pyPath};
            Process process = Runtime.getRuntime().exec(args);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String[] keys = in.readLine().trim().split("\\s+");
            String res = in.readLine();
            while (res != null) {
                String[] params = res.trim().split("\\s+");
                BalanceDto balanceDto = new BalanceDto();
                balanceDto.setDealDate(params[1]);
                balanceDto.setDealAmount(new BigDecimal(params[2]));
                balanceDtos.add(balanceDto);
                res = in.readLine();
            }
            in.close();
            process.waitFor();
        } catch (Exception e) {
            System.out.printf("调用脚本: %s\n", e.getMessage());
        }
        return CommonResult.success(balanceDtos);
    }
}
