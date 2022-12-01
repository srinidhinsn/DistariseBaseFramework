package com.distarise.credaegis.enumerations;

import java.util.Arrays;
import java.util.Optional;

public enum AccountType {

    Credit_Card("Credit Card"),
    Gold_Loan("Gold Loan");
    private String accountType;
    AccountType(String type) {
        this.accountType = type;
    }

    public Optional<AccountType> findAccountType(String s) {
        Optional<AccountType> returnAccountType =
                Arrays.stream(AccountType.values()).filter(type -> s.contains(type.accountType)).findFirst();
        return returnAccountType;
    }


}
