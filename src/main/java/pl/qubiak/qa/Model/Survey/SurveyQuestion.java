package pl.qubiak.qa.Model.Survey;

import io.swagger.annotations.ApiModelProperty;

public class SurveyQuestion {

    @ApiModelProperty(notes = "AUTO_INCREMENT")
    private int id;
    private String surveyQuestion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurveyQuestion() {
        return surveyQuestion;
    }

    public void setSurveyQuestion(String surveyQuestion) {
        this.surveyQuestion = surveyQuestion;
    }
}
