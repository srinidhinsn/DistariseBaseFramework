package com.distarise.credaegis.service.impl;

import com.distarise.credaegis.constants.CibilConstants;
import com.distarise.credaegis.model.LeadDto;
import com.distarise.credaegis.model.PersonDto;
import com.distarise.credaegis.service.CreditAnalysisService;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder.In;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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

            latestPaymentDone = getLastPaymentDone(accountInfo);
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
        String cibilScoreStr = pdf.substring(pdf.indexOf(CibilConstants.CIBIL_SCORE) - 3,
                pdf.indexOf(CibilConstants.CIBIL_SCORE)).trim();
        personDto.setCreditScore(Integer.parseInt(cibilScoreStr));
    }

    private String getLastPaymentDone(String accountInfo){
        int dateFormatLength = 10;
        int paymentScheduleLength = 8;
        int paymentScheduleMovingLength = 0;
        Pattern paymentPattern = Pattern.compile("([A-Z][a-z]{2}) ([0-9]{4})");
        String latestPaymentDoneTmp = "";
        String latestPaymentStrMatch = "";
        String latestPaymentDone = "";
        List<String> paymentSchedule = new ArrayList<>();

        latestPaymentDoneTmp = accountInfo.substring(
                accountInfo.indexOf(CibilConstants.ACCOUNT_PAYMENT_DETAIL) +
                        CibilConstants.ACCOUNT_PAYMENT_DETAIL.length() + dateFormatLength,
                accountInfo.indexOf(CibilConstants.ACCOUNT_PAYMENT_END));

        Matcher match = paymentPattern.matcher(latestPaymentDoneTmp);
        while(match.find()){
            paymentSchedule.add(match.group());
        }

        for (int count=0; count < paymentSchedule.size()-1; count++){
            String dpdStr = latestPaymentDoneTmp.substring(
                    latestPaymentDoneTmp.indexOf(paymentSchedule.get(count)) + paymentSchedule.get(count).length(),
                    latestPaymentDoneTmp.indexOf(paymentSchedule.get(count+1))).trim();
            try{
                Integer dpd = Integer.parseInt(dpdStr);
                if (dpd > 0) {
                    latestPaymentDone = paymentSchedule.get(count) + " " + dpd;
                    break;
                }
            } catch (NumberFormatException nfe){
            }
            Optional<String> statusFound = CibilConstants.getPaymentDefaultStatusList().stream().filter(status -> dpdStr.equals(status)).findFirst();
            if (statusFound.isPresent()){
                latestPaymentDone = paymentSchedule.get(count) + " " + dpdStr;
                break;
            }
        }
        return latestPaymentDone;
    }

}
