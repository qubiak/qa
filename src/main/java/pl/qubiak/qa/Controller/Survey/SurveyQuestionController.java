package pl.qubiak.qa.Controller.Survey;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.qubiak.qa.DAO.Survey.SurveyQuestionDao;

@Controller
@RequestMapping("/surveyQuestion")
public class SurveyQuestionController {

    public SurveyQuestionDao surveyQuestionDao;

    @RequestMapping("/surveyQuestion")
    public void saveSurveyQuestion(
            @RequestParam("surveyQuestion") String surveyQuestion) {
        surveyQuestionDao.saveSurveyQuestion(surveyQuestion);
    }

    @RequestMapping("/editSurveyQuestion")
    public void editSurveyQuestion(
            @RequestParam("id") int id,
            @RequestParam("surveyQuestion") String surveyQuestion) {
        surveyQuestionDao.editSurveyQuestion(id, surveyQuestion);
    }

    @RequestMapping("/delateSurveyQuestionById")
    public void delateSurveyQuestionById(
            @RequestParam("id") int id) {
        surveyQuestionDao.delateSurvayQuestionById(id);
    }
}
