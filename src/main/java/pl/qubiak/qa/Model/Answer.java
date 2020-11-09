package pl.qubiak.qa.Model;

import com.vaadin.flow.component.polymertemplate.Id;

public class Answer {

    @Id
    private int id;
    private int questionId;
    private String Answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswer(String answer) {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
