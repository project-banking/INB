package com.diaspark.INB.entity;

import com.diaspark.INB.exception.InvalidTransactionException;

public enum UtilityAccounts {

    Internet(2, "internet"),
    Electricity(3, "electricity"),
    Mobile(4, "mobile");

    private int customerId;
    private String utilityType;

    UtilityAccounts(int customerId, String utilityType) {
        this.customerId = customerId;
        this.utilityType = utilityType;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getUtilityType() {
        return utilityType;
    }

    public void setUtilityType(String utilityType) {
        this.utilityType = utilityType;
    }

    public static UtilityAccounts findCustomerByType(String utilityType) {
        for (UtilityAccounts utilityCustomer : values()) {
            if (utilityType.equals(utilityCustomer.getUtilityType())) {
                return utilityCustomer;
            }
        }
        throw new InvalidTransactionException("Incorrect transaction type");
    }
}

