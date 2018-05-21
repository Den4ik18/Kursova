package com.ohorodnik.lab5db.requestModel;

public class AmountCustomer {
    long amountCustomer;

    public AmountCustomer(long amountCustomer) {
        this.amountCustomer = amountCustomer;
    }

    public AmountCustomer() {
    }

    public long getAmountCustomer() {
        return amountCustomer;
    }

    public void setAmountCustomer(long amountCustomer) {
        this.amountCustomer = amountCustomer;
    }
}
