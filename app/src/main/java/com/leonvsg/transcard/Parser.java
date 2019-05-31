package com.leonvsg.transcard;

public class Parser {

    public CardRequestModel parseCardRequstModel(String html){
        return new CardRequestModel("4102280055",
                "/wEPDwUKMjA0MTYzNzA4MWQYAQUGY2NKb2luDwUkMDY4MWM0ZTYtNzFlMi00NmZkLTllOWYtY2IzMTY1ZTY3MGVkZD4zHTbBcl/mrSWScLWrkrCfCt/a",
                "/wEWBAKSuouhBAKyxee2BQKu44nWDQK7q7GGCEc+8UXo/WIKPvZ/w59twsGhvpcz",
                "http://81.23.146.8/CaptchaImage.axd?guid=33c8b03f-99e0-41e8-a840-8ffc5e9b8b74");
    }

}
