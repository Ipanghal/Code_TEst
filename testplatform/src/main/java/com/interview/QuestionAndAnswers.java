package com.interview;

import java.util.*;

public class QuestionAndAnswers {

    String question;
    Set<String> answers;

    public QuestionAndAnswers(String question) {
        this.question = question;
    }

    public Set<String> getAnswers() {
        return answers;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswers(Set<String> answers) {
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

}
