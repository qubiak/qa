package pl.qubiak.qa.Model;

import com.vaadin.flow.component.polymertemplate.Id;

public class QaModel {

    @Id
    private int id;
    private String question;
    private String answer;
    private int counter;

    public QaModel(int id, String question, String answer, int counter) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.counter = counter;
    }

    public QaModel(int id, String answer) {
        this.id = id;
        this.answer = answer;
    }

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
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
