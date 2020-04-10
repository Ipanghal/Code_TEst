package com.interview;

import java.util.HashMap;
import java.util.Set;

public class AskQuestion {



    HashMap<String, Set<String>> dataMpp =new HashMap<String,Set<String>>();

    public AskQuestion() {

    }

    public HashMap<String, Set<String>> getAskedQestionFromSystem(String question){

        return dataMpp;
    }


    public void setDataMpp(HashMap<String, Set<String>> dataMpp) {
        this.dataMpp = dataMpp;
    }

    public HashMap<String, Set<String>> getDataMpp() {

        return dataMpp;
    }

}
