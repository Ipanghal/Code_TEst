package com.interview;

import java.util.ArrayList;

public class AddedQuestionsList {


    ArrayList<QuestionAndAnswers> list = new ArrayList();
    public ArrayList<QuestionAndAnswers> adding(QuestionAndAnswers q){
        list.add(q);
        return list;
    }
    public void show() {
        int g = list.size();
        int count = 0;
        while (count < g) {
            list.get(count);
        }
    }
}
