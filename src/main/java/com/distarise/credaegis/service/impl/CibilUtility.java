package com.distarise.credaegis.service.impl;

import com.distarise.base.action.AbstractBaseAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CibilUtility {
    private static final Logger logger = LoggerFactory.getLogger(CibilUtility.class);
    public static String getStringBetween(String content, String start, String end){
        return content.substring(content.indexOf(start) + start.length(), content.indexOf(end));
    }

    public static String getStringBetween(String content, int start, String end){
        return content.substring(start, content.indexOf(end));
    }

    public static String getStringBetween(String content, String start, int end){
        return content.substring(content.indexOf(start) + start.length(),
                content.indexOf(start) + start.length() + end);
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

    public static Date ddmmyyyyToDate(String dateStr){
        try{
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
            return date;
        }
        catch (ParseException pe){
            logger.error("Date Parsing exception - "+dateStr);
            return null;
        }
    }
}
