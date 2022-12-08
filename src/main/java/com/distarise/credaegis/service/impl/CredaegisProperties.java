package com.distarise.credaegis.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;


//@ConfigurationProperties
//@PropertySource("classpath:credaegis.properties")
@Service
public class CredaegisProperties {

    private String accountTypes="Gold Loan,Car Loan,Personal Loan,Credit Card,Two-wheeler Loan,Home Loan,Consumer Loan,Business Loan ? General,Microfinance ? BusinessLoan,Business Loan -Unsecured,Other,Commercial Vehicle Loan,Housing Loan,AUTO LOAN(PERSONAL),Loan –General,Microfinance –Business Loan";

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
