package io.bankapp;

public class WebDto {
    private String intentName;
    private String accountNumber;
    private String pan;
    private String mobileNumber;

    public String getIntentName() {
        return intentName;
    }

    public void setIntentName(String intentName) {
        this.intentName = intentName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "WebDto{" +
                "intentName='" + intentName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", pan='" + pan + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
