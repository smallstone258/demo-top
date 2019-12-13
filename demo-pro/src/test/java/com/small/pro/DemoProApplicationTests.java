package com.small.pro;

import org.apache.commons.lang.math.NumberUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;

@SpringBootTest
class DemoProApplicationTests {

 /*   @Test
    void contextLoads() {
    }*/

    public static void main(String[] args) {
        Double ppmValue = new Integer(30)*new Integer(8) / Double.parseDouble((new Integer(300) * new Integer(100)) + "") * 1000000;

        //Double zz = po.getBadPointTotal()*po.getDefectiveNum() / Double.parseDouble((po.getProductionNum() * po.getAmount()) + "") * 1000000;
        //sampling.setPpmValue(NumberUtils.toScaledBigDecimal(ppmValue, 0, RoundingMode.HALF_UP).intValue());
        //BigDecimal b = new BigDecimal(ppmValue);

        System.out.println(ppmValue);
        System.out.println(Integer.valueOf(String.valueOf(Math.round(ppmValue)).toString()));
        System.out.println(String.valueOf(Math.round(ppmValue)));
        //14286
        //（不良点数*次品数量）/（质检数*产品点数）*1000000
    }




}
