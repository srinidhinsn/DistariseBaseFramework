package com.distarise.credaegis.service.impl;

import com.distarise.credaegis.constants.CibilConstants;

public class CibilUtility {

    public static String getStringBetween(String content, String start, String end){
        return content.substring(content.indexOf(start) + start.length(), content.indexOf(end));
    }

    public static String getStringBetween(String content, int start, String end){
        return content.substring(start, content.indexOf(end));
    }

    public static Long convertStringToLong(String money){
        money = money.replaceAll(",","");
        money = money.replaceAll(" ","");
        money = money.replaceAll("-","");
        if (money.isEmpty()){
            return 0L;
        }
        return Long.parseLong(money);
    }

}
