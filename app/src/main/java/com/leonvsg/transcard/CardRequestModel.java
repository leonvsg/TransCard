package com.leonvsg.transcard;

public class CardRequestModel {

    private String checkcode;
    private String cardnum;
    private String __VIEWSTATE;
    private String __EVENTVALIDATION;
    private String __EVENTTARGET;
    private String __EVENTARGUMENT;
    private String Button2;
    private String checkCodeUri;

    public CardRequestModel(String __VIEWSTATE, String __EVENTVALIDATION, String checkCodeUri) {
        this.cardnum = "4102280055";
        this.checkcode = "1234";
        this.cardnum = cardnum;
        this.__VIEWSTATE = __VIEWSTATE;
        this.__EVENTVALIDATION = __EVENTVALIDATION;
        this.__EVENTTARGET = "";
        this.__EVENTARGUMENT = "";
        Button2 = "Выполнить запрос";
        this.checkCodeUri = checkCodeUri;
    }

    public CardRequestModel(String cardnum, String __VIEWSTATE, String __EVENTVALIDATION, String checkCodeUri) {
        this.cardnum = cardnum;
        this.checkcode = "1234";
        this.cardnum = cardnum;
        this.__VIEWSTATE = __VIEWSTATE;
        this.__EVENTVALIDATION = __EVENTVALIDATION;
        this.__EVENTTARGET = "";
        this.__EVENTARGUMENT = "";
        Button2 = "Выполнить запрос";
        this.checkCodeUri = checkCodeUri;
    }

    public String getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public String get__VIEWSTATE() {
        return __VIEWSTATE;
    }

    public void set__VIEWSTATE(String __VIEWSTATE) {
        this.__VIEWSTATE = __VIEWSTATE;
    }

    public String get__EVENTVALIDATION() {
        return __EVENTVALIDATION;
    }

    public void set__EVENTVALIDATION(String __EVENTVALIDATION) {
        this.__EVENTVALIDATION = __EVENTVALIDATION;
    }

    public String get__EVENTTARGET() {
        return __EVENTTARGET;
    }

    public void set__EVENTTARGET(String __EVENTTARGET) {
        this.__EVENTTARGET = __EVENTTARGET;
    }

    public String get__EVENTARGUMENT() {
        return __EVENTARGUMENT;
    }

    public void set__EVENTARGUMENT(String __EVENTARGUMENT) {
        this.__EVENTARGUMENT = __EVENTARGUMENT;
    }

    public String getButton2() {
        return Button2;
    }

    public void setButton2(String button2) {
        Button2 = button2;
    }

    public String getCheckCodeUri() {
        return checkCodeUri;
    }

    public void setCheckCodeUri(String checkCodeUri) {
        this.checkCodeUri = checkCodeUri;
    }

    @Override
    public String toString() {
        return "CardRequestModel{" +
                "checkcode='" + checkcode + '\'' +
                ", cardnum='" + cardnum + '\'' +
                ", __VIEWSTATE='" + __VIEWSTATE + '\'' +
                ", __EVENTVALIDATION='" + __EVENTVALIDATION + '\'' +
                ", __EVENTTARGET='" + __EVENTTARGET + '\'' +
                ", __EVENTARGUMENT='" + __EVENTARGUMENT + '\'' +
                ", Button2='" + Button2 + '\'' +
                ", checkCodeUri='" + checkCodeUri + '\'' +
                '}';
    }
}
