package com.distarise.credaegis.service.impl;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;


//@ConfigurationProperties
//@PropertySource("classpath:credaegis.properties")
@Service
public class CredaegisProperties {

    private String accountTypes="Credit Card,Leasing,Overdraft,Two-wheeler Loan," +
            "Non-Funded Credit Facility,Loan Against Bank Deposits,Fleet Card,Commercial Vehicle Loan," +
            "Telco – Wireless,Telco – Broadband,Telco – Landline,Seller Financing,GECL Loan Secured," +
            "GECL Loan Unsecured,Secured Credit Card,Used Car Loan,Construction Equipment Loan," +
            "Tractor Loan,Corporate Credit Card,Kisan Credit Card,Loan on Credit Card," +
            "Prime Minister Jaan Dhan Yojana - Overdraft,Microfinance – Business Loan," +
            "Microfinance – Personal Loan,Microfinance – Housing Loan,Microfinance – Other," +
            "Pradhan Mantri Awas Yojana - Credit Link Subsidy Scheme MAY CLSS,P2P Personal Loan," +
            "P2P Auto Loan,P2P Education Loan,Business Loan - Secured,Business Loan – General," +
            "Business Loan – Priority Sector – Small Business,Business Loan – Priority Sector – Agriculture," +
            "Business Loan – Priority Sector – Others,Business Non-Funded Credit Facility – General," +
            "Business Non-Funded Credit Facility – Priority Sector – Small Business," +
            "Business Non-Funded Credit Facility – Priority Sector – Agriculture," +
            "Business Non-Funded Credit Facility – Priority Sector-Others,Business Loan Against Bank Deposits," +
            "Business Loan - Unsecured,Auto Loan Personal,Housing Loan,Property Loan," +
            "Loan Against Shares or Securities,Personal Loan,Consumer Loan,Gold Loan,Education Loan," +
            "Loan to Professional,Other";

    private String ownershipTypes="Individual,Joint,Guarantor";

    public String getAccountTypes() {
        return accountTypes;
    }

    public void setAccountTypes(String accountTypes) {
        this.accountTypes = accountTypes;
    }

    public String getOwnershipTypes() {
        return ownershipTypes;
    }

    public void setOwnershipTypes(String ownershipTypes) {
        this.ownershipTypes = ownershipTypes;
    }

    public String getAccountType(String type) {
        Optional<String> accountType = Arrays.asList(accountTypes.split(",")).stream().
                filter(s -> type.contains(s)).findFirst();
        return accountType.isPresent()? accountType.get() : " ";
    }

    public String getOwnershipType(String type) {
        Optional<String> ownershipType = Arrays.asList(ownershipTypes.split(",")).stream().
                filter(s -> type.contains(s)).findFirst();
        return ownershipType.isPresent()? ownershipType.get() : " ";
    }
}
