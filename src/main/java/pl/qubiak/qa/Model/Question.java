package pl.qubiak.qa.Model;

import com.vaadin.flow.component.polymertemplate.Id;

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

    public int getCounter() {
        return like_counter;
    }

    public void setCounter(int counter) {
        this.like_counter = counter;
    }

    public Question withQuestion(final String question) {
        this.question = question;
        return this;
    }

    public Question withCounter(final int like_counter) {
        this.like_counter = like_counter;
        return this;
    }

    public Question(int id, String question, int like_counter) {
        this.id = id;
        this.question = question;
        this.like_counter = like_counter;
    }

    public Question() {
    }
}

