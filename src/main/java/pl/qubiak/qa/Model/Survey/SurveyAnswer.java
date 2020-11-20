package pl.qubiak.qa.Model.Survey;

import io.swagger.annotations.ApiModelProperty;

public class SurveyAnswer {

    @ApiModelProperty(notes = "AUTO_INCREMENT")
    private int id;
    private int surveyQuestionId;
    private String surveyAnswer;
    private int numberOfSelections;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSurveyQuestionId() {
        return surveyQuestionId;
    }

    public void setSurveyQuestionId(int surveyQuestionId) {
        this.surveyQuestionId = surveyQuestionId;
    }

    public String getSurveyAnswer() {
        return surveyAnswer;
    }

    public void setSurveyAnswer(String surveyAnswer) {
        this.surveyAnswer = surveyAnswer;
    }

    public int getNumberOfSelections() {
        return numberOfSelections;
    }

    public void setNumberOfSelections(int numberOfSelections) {
        this.numberOfSelections = numberOfSelections;
    }
}
