package com.example.kalakrishnankr.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kalakrishnan.kr on 24/5/17.
 */

public class JSONResponse {
   /* public String id;

    public String getQuestion() {
        return question;
    }

    public String getId() {
        return id;
    }

    public String question;*/

    public List<String> getQuestResultionid() {
        return questResultionid;
    }

    public void setQuestResultionid(List<String> questResultionid) {
        this.questResultionid = questResultionid;
    }

    @SerializedName("Result")
    public List<String> questResultionid;
//    @SerializedName("Question_Desc")
//    public String question_desc;
}
