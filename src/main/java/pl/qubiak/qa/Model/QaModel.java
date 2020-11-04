package pl.qubiak.qa.Model;

import com.vaadin.flow.component.polymertemplate.Id;

public class QaModel {

    @Id
    private int id;
    private String question;
    private String answer;
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getCounter() {
        return like_counter;
    }

    public void setCounter(int counter) {
        this.like_counter = counter;
    }
}
