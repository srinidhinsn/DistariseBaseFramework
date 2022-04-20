package com.distarise.distabank.util;

import com.distarise.distabank.customer.model.CustomerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class DistabankUtils {

    private static final Logger logger = LoggerFactory.getLogger(DistabankUtils.class);
    public static final String GENERIC_SEPERATOR = "::";
    public static final int PADDING_LENGTH = 14;
    public static boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public static Date stringYYYYMMDDToDate(String dateString){
        Date date = null;
        try{
            if(null != dateString && !dateString.isEmpty()){
                date = new SimpleDateFormat(CustomerDto.DATE_YYYY_MM_DD).parse(dateString);
            }
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        return date;
    }

    public static String padAccountNo(String clientId, String str1, String str2){
        StringBuffer sb = new StringBuffer();
        sb.append(str1).append(clientId.substring(0,2));
        int remainingPadding = PADDING_LENGTH - (sb.length() + str2.length());
        for(int i=0; i<remainingPadding ; i++){
            sb.append("0");
        }
        sb.append(str2);
        return sb.toString().toUpperCase();
    }

}
