package com.example.kalakrishnankr.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by kalakrishnan.kr on 24/5/17.
 */

public interface ApiService {


//        @Headers({"X-PartnerKey: 3f04c2f0-6257-4679-9148-6a729f7d6f84","Authorization : Basic aWRjc3BydWU6dGVzdDEyMzQ=","Content-Type : application/json"})
//    @GET("idcsprue/loginuser")
    @Headers({"X-PartnerKey: qagate123","Authorization: Basic YWRtaW46YWRtaW4="})
    @GET("getAllQuestions")
    Call<JSONResponse>getJSON();
}
