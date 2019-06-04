package com.leonvsg.transcard;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class Parser {

    public CardRequestModel parseCardRequestModel(String htmlString){
        Element body = Jsoup.parse(htmlString).body();
        String viewstate = body.getElementById("__VIEWSTATE").val();
        String eventvalidation = body.getElementById("__EVENTVALIDATION").val();
        String imgUri = "http://81.23.146.8/" + body.getElementsByTag("img").attr("src");
        return new CardRequestModel(viewstate, eventvalidation, imgUri);
    }
}
