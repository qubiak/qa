package pl.qubiak.qa.Model;

import com.vaadin.flow.component.polymertemplate.Id;

import java.util.List;

public class Question {

    @Id
    private int id;
    private String question;
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


