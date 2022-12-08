package com.distarise.credaegis.service.impl;

import com.distarise.credaegis.constants.CibilConstants;
import com.distarise.credaegis.model.LeadDto;
import com.distarise.credaegis.model.PersonDto;
import com.distarise.credaegis.service.CreditAnalysisService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CibilAnalysisServiceImpl implements CreditAnalysisService {

    @Override
    public PersonDto setPersonalInfo(String pdf, PersonDto personDto) {
        Pattern dobPattern = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");
        String dobStringFormat = "dd/mm/yyyy";
        String dobString = null;
        Matcher match = dobPattern.matcher(pdf);
        if (match.find()){
            dobString = match.group();
            try {
                Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(dobString);
                personDto.setDob(dob);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        if (null != dobString){
            String[] details = pdf.split(dobString);
            personDto.setFirstName(details[0]);
            if (details[1].equalsIgnoreCase("Male")){
                personDto.setGender('M');
            } else if (details[1].equalsIgnoreCase("Female")){
                personDto.setGender('F');
            }
        }
        return personDto;
    }

    @Override
    public List<LeadDto> createLeads(List<String> accountsInfoList) {
        List<LeadDto> leadDtoList = new ArrayList<>();
        CredaegisProperties credaegisProperties = new CredaegisProperties();
        int dateFormatLength = 10;
        int approxLatestPaymentLength = 19;
        Pattern dobPattern = Pattern.compile("([A-Z][a-z]{2}) ([0-9]{4})");
        accountsInfoList.forEach(accountInfo -> {
            LeadDto leadDto = new LeadDto();

            // Account summary extraction
            String accountSummary = CibilUtility.getStringBetween(accountInfo, 0,
                    CibilConstants.ACCOUNT_DETAILS);

            String accountType = credaegisProperties.getAccountType(accountSummary);
            String ownershipType = credaegisProperties.getOwnershipType(accountSummary);
            String accountName = accountSummary.substring(0, accountSummary.indexOf(accountType));
            String accountNumber = accountSummary.substring(
                    accountSummary.indexOf(accountType) + accountType.length(),
                    accountSummary.indexOf(ownershipType));
            leadDto.setAccountNo(accountNumber);
            leadDto.setAccountName(accountName);
            leadDto.setAccountType(accountType);
            leadDto.setOwnership(ownershipType);

            //Account details extraction
            String accountDetails = CibilUtility.getStringBetween(accountInfo, CibilConstants.ACCOUNT_DETAILS,
                    CibilConstants.ACCOUNT_PAYMENT);
            String sanctionedAmountStr = "";
            String currentBalStr = "";
            String amtOverdueStr = "";
            String creditStatus = "";
            String latestPaymentDone = "";
            String latestPaymentDoneTmp = "";
            String latestPaymentStrMatch = "";
            String highCreditStr = "";

            Long sanctionedAmount = null;
            Long currentBal = null;
            Long amtOverdue = null;
            Long highCredit = null;

            if (accountType.equalsIgnoreCase(CibilConstants.ACCOUNT_TYPE_CREDIT_CARD)){
                 sanctionedAmountStr = CibilUtility.getStringBetween(accountDetails,
                         CibilConstants.ACCOUNT_DETAILS_CREDIT_LIMIT,
                         CibilConstants.ACCOUNT_DETAILS_HIGH_CREDIT);

                 highCreditStr = CibilUtility.getStringBetween(accountDetails,
                         CibilConstants.ACCOUNT_DETAILS_HIGH_CREDIT,
                         CibilConstants.ACCOUNT_DETAILS_CURRENT_BALANCE);
            } else {
                sanctionedAmountStr = CibilUtility.getStringBetween(accountDetails,
                        CibilConstants.ACCOUNT_DETAILS_SANCTIONED_AMOUNT,
                        CibilConstants.ACCOUNT_DETAILS_CURRENT_BALANCE);
            }

            currentBalStr = CibilUtility.getStringBetween(accountDetails,
                    CibilConstants.ACCOUNT_DETAILS_CURRENT_BALANCE,
                    CibilConstants.ACCOUNT_DETAILS_CASH_LIMIT);

            amtOverdueStr = CibilUtility.getStringBetween(accountDetails,
                    CibilConstants.ACCOUNT_DETAILS_AMOUNT_OVERDUE,
                    CibilConstants.ACCOUNT_DETAILS_INTEREST_RATE);

            creditStatus = CibilUtility.getStringBetween(accountDetails,
                    CibilConstants.ACCOUNT_DETAILS_CREDIT_STATUS,
                    CibilConstants.ACCOUNT_DETAILS_WRITTENOFF_AMOUNT);
            creditStatus = creditStatus.replaceAll("-","");
            latestPaymentDoneTmp = accountInfo.substring(
                    accountInfo.indexOf(CibilConstants.ACCOUNT_PAYMENT_DETAIL) +
                            CibilConstants.ACCOUNT_PAYMENT_DETAIL.length() + dateFormatLength,
                    accountInfo.indexOf(CibilConstants.ACCOUNT_PAYMENT_DETAIL) +
                            CibilConstants.ACCOUNT_PAYMENT_DETAIL.length() + dateFormatLength +
                            approxLatestPaymentLength
            );

            latestPaymentDone = latestPaymentDoneTmp.substring(0, 8);
            latestPaymentDoneTmp = latestPaymentDoneTmp.substring(8, approxLatestPaymentLength);
            Matcher match = dobPattern.matcher(latestPaymentDoneTmp);
            if(match.find()){
                latestPaymentStrMatch = match.group();
            }
            latestPaymentDone+=latestPaymentDoneTmp.substring(0,latestPaymentDoneTmp.indexOf(latestPaymentStrMatch));

            sanctionedAmount = CibilUtility.convertStringToLong(sanctionedAmountStr);
            highCredit = CibilUtility.convertStringToLong(highCreditStr);
            currentBal = CibilUtility.convertStringToLong(currentBalStr);
            amtOverdue = CibilUtility.convertStringToLong(amtOverdueStr);

            leadDto.setAmountOverdue(amtOverdue);
            leadDto.setCreditStatus(creditStatus);
            leadDto.setCurrentBalance(currentBal);
            leadDto.setLatestPaymentDone(latestPaymentDone);
            leadDto.setSanctionedAmount(sanctionedAmount);
            leadDto.setHighCredit(highCredit);
            leadDtoList.add(leadDto);
        });
        return leadDtoList;
    }

    @Override
    public void setCreditScore(String pdf, PersonDto personDto) {
        String cibilScoreStr = pdf.substring(pdf.indexOf(CibilConstants.CIBIL_SCORE) + CibilConstants.CIBIL_SCORE.length(),
                pdf.indexOf(CibilConstants.CIBIL_SCORE) + CibilConstants.CIBIL_SCORE.length() + 3).trim();
        personDto.setCreditScore(Integer.parseInt(cibilScoreStr));
    }


}
