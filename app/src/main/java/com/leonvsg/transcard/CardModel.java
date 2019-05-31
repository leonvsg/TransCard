package com.leonvsg.transcard;

public class CardModel {

    private String balance;
    private String number;

    public CardModel(String balance, String number) {
        this.balance = balance;
        this.number = number;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
