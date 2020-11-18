package pl.qubiak.qa.Model;

import io.swagger.annotations.ApiModelProperty;

public class Answer {

    @ApiModelProperty(notes = "AUTO_INCREMENT")
    private int id;
    @ApiModelProperty(notes = "id of the question to which we will add the answer")
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

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

}
