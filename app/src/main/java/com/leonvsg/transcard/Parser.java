package com.leonvsg.transcard;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Parser {

    public CardRequestModel parseCardRequestModel(String htmlString){

        Document html = Jsoup.parse(htmlString);


        return new CardRequestModel("4102280055",
                "/wEPDwUKMjA0MTYzNzA4MWQYAQUGY2NKb2luDwUkMDY4MWM0ZTYtNzFlMi00NmZkLTllOWYtY2IzMTY1ZTY3MGVkZD4zHTbBcl/mrSWScLWrkrCfCt/a",
                "/wEWBAKSuouhBAKyxee2BQKu44nWDQK7q7GGCEc+8UXo/WIKPvZ/w59twsGhvpcz",
                "https://suptest.000webhostapp.com/image.jpg");
    }

}
