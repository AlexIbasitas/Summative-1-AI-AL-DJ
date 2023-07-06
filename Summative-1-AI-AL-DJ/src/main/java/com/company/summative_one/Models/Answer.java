package com.company.summative_one.Models;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Answer {
    private int id;
    private String question;

    private String answer; // will contain at least 6 strings

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Answer(){
    }

}
