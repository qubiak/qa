package pl.qubiak.qa.Model;

import io.swagger.annotations.ApiModelProperty;

public class Question {

    @ApiModelProperty(notes = "AUTO_INCREMENT")
    private int id;
    private String question;
    @ApiModelProperty(notes = "a counter indicating whether a given question is liked or not")
    private int like_counter;

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

    public int getLike_counter() {
        return like_counter;
    }

    public void setLike_counter(int like_counter) {
        this.like_counter = like_counter;
    }
}


