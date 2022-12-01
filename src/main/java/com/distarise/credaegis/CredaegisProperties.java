package com.distarise.credaegis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@PropertySource("credaegis.properties")
public class CredaegisProperties {

    @Value("AccountTypes")
    private String accountTypes;

    @Value("OwnershipTypes")
    private String ownershipTypes;

    public String getAccountType(String type) {
        Optional<String> accountType = Arrays.asList(accountTypes.split(",")).stream().
                filter(s -> type.toLowerCase().contains(s.toLowerCase())).findFirst();
        return accountType.isPresent()? type : " ";
    }

    public String getOwnershipType(String type) {
        Optional<String> ownershipType = Arrays.asList(ownershipTypes.split(",")).stream().
                filter(s -> type.toLowerCase().contains(s.toLowerCase())).findFirst();
        return ownershipType.isPresent()? type : " ";
    }
}
