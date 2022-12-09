package com.distarise.credaegis.constants;

import java.util.ArrayList;
import java.util.List;

public class CibilConstants {

    public static final String CREDAEGIS_CONTEXT = "credaegisContext";
    public static final String PERSON_START = "Personal InformationNameDOBGender";
    public static final String PERSON_ID_START = "Identification TypeNumberIssue DateExpiration Date";
    public static final String PERSON_PAN = "Income Tax ID Number (PAN)";
    public static final String PERSON_BREAK = "--";

    public static final String ACCOUNT_START = "Account InformationMember NameAccount TypeAccount NumberOwnership";
    public static final String ACCOUNT_DETAILS = "Account Details";
    public static final String ACCOUNT_PAYMENT = "Payment Status (up to 36 months)";
    public static final String ACCOUNT_BREAK = "LSS:LossXXX: Not ReportedSUB:Substandard";
    public static final String ACCOUNT_END = "Enquiry InformationMember NameDate of EnquiryEnquiry PurposeEnquiry";


    public static final String ACCOUNT_TYPE_CREDIT_CARD = "Credit Card";

    public static final String ACCOUNT_DETAILS_CREDIT_LIMIT = "Credit Limit";
    public static final String ACCOUNT_DETAILS_HIGH_CREDIT = "High Credit";
    public static final String ACCOUNT_DETAILS_SANCTIONED_AMOUNT = "Sanctioned Amount";
    public static final String ACCOUNT_DETAILS_CURRENT_BALANCE = "Current Balance";
    public static final String ACCOUNT_DETAILS_CASH_LIMIT = "Cash Limit";
    public static final String ACCOUNT_DETAILS_AMOUNT_OVERDUE = "Amount Overdue";
    public static final String ACCOUNT_DETAILS_INTEREST_RATE = "Rate of Interest";
    public static final String ACCOUNT_DETAILS_CREDIT_STATUS = "Credit Facility Status";
    public static final String ACCOUNT_DETAILS_WRITTENOFF_AMOUNT = "Written-off Amount (Total)";
    public static final String ACCOUNT_PAYMENT_DETAIL = "Payment End Date";

    public static final String ACCOUNT_PAYMENT_END = "STD: Standard";
    public static final String PS_AMOUNT_OVERDUE = "Amount overdue - ";
    public static final String PS_DPD = "DPD - ";

    public static final String CIBIL_SCORE = "This section reflects your CIBIL Score";

    public static List<String> PAYMENT_STATUS_LIST = new ArrayList<>();
    public static List<String> PAYMENT_STATUS_DEFAULT_LIST = new ArrayList<>();
    public static final String PAYMENT_STATUS_STD = "STB";
    public static final String PAYMENT_STATUS_DBT = "DBT";
    public static final String PAYMENT_STATUS_SMA = "SMA";
    public static final String PAYMENT_STATUS_LSS = "LSS";
    public static final String PAYMENT_STATUS_XXX = "XXX";
    public static final String PAYMENT_STATUS_SUB = "SUB";

    public static List<String> getPaymentDefaultStatusList(){
        PAYMENT_STATUS_DEFAULT_LIST.add("DBT");
        PAYMENT_STATUS_DEFAULT_LIST.add("SMA");
        PAYMENT_STATUS_DEFAULT_LIST.add("LSS");
        PAYMENT_STATUS_DEFAULT_LIST.add("XXX");
        PAYMENT_STATUS_DEFAULT_LIST.add("SUB");
        return PAYMENT_STATUS_DEFAULT_LIST;
    }
}
