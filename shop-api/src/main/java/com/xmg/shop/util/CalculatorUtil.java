package com.xmg.shop.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author
 * @date 2017/8/15
 */
public class CalculatorUtil {

    private CalculatorUtil(){}
    /**
     * 循环实现dimValue中的笛卡尔积
     * @param dimValue 原始数据
     */
    public static List<List<String>> circulate (List<List<String>> dimValue) {
        int total = 1;
        for (List<String> list : dimValue) {
            total *= list.size();
        }
        String[] myResult = new String[total];

        int itemLoopNum = 1;
        int loopPerItem = 1;
        int now = 1;
        for (List<String> list : dimValue) {
            now *= list.size();

            int index = 0;
            int currentSize = list.size();

            itemLoopNum = total / now;
            loopPerItem = total / (itemLoopNum * currentSize);
            int myIndex = 0;

            for (String string : list) {
                for (int i = 0; i < loopPerItem; i++) {
                    if (myIndex == list.size()) {
                        myIndex = 0;
                    }

                    for (int j = 0; j < itemLoopNum; j++) {
                        myResult[index] = (myResult[index] == null? "" : myResult[index] + ",") + list.get(myIndex);
                        index++;
                    }
                    myIndex++;
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        List<String> stringResult = Arrays.asList(myResult);
        for (String string : stringResult) {
            String[] stringArray = string.split(",");
            result.add(Arrays.asList(stringArray));
        }
        return result;
    }
}
