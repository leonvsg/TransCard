package com.leonvsg.transcard;

import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpClient {

    private final OkHttpClient client;

    public HttpClient() {
        client = new OkHttpClient();
    }

    public void run(Callback callback) {
        Request request = new Request.Builder()
                .url("http://81.23.146.8/default.aspx")
                .build();
        client.newCall(request).enqueue(callback);
    }

    public void run(Callback callback, CardRequestModel params){
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("cardnum", params.getCardnum())
                .addFormDataPart("checkcode", params.getCheckcode())
                .addFormDataPart("__VIEWSTATE", params.get__VIEWSTATE())
                .addFormDataPart("__EVENTVALIDATION", params.get__EVENTVALIDATION())
                .addFormDataPart("__EVENTTARGET", "")
                .addFormDataPart("__EVENTARGUMENT", "")
                .addFormDataPart("Button2", "Выполнить запрос")
                .build();
        Request request = new Request.Builder()
                .url("http://81.23.146.8/default.aspx")
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
