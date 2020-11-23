package pl.qubiak.qa.Controller.Survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.qubiak.qa.DAO.Survey.SurveyQuestionDao;

@Controller
@RequestMapping("/surveyQuestion")
public class SurveyQuestionController {

    @Autowired
    public SurveyQuestionDao surveyQuestionDao;

    @RequestMapping("/saveSurveyQuestion")
    @ResponseBody
    //http://localhost:8080/surveyQuestion/saveSurveyQuestion?surveyQuestion=pytanieTestowe
    public void saveSurveyQuestion(
            @RequestParam("surveyQuestion") String surveyQuestion) {
        surveyQuestionDao.saveSurveyQuestion(surveyQuestion);
    }

    @RequestMapping("/editSurveyQuestion")
    @ResponseBody
    //http://localhost:8080/surveyQuestion/editSurveyQuestion?id=1&surveyQuestion=edytowanePytanie
    public void editSurveyQuestion(
            @RequestParam("id") int id,
            @RequestParam("surveyQuestion") String surveyQuestion) {
        surveyQuestionDao.editSurveyQuestion(id, surveyQuestion);
    }

    @RequestMapping("/delateSurveyQuestionById")
    @ResponseBody
    //http://localhost:8080/surveyQuestion/delateSurveyQuestionById?id=1
    public void delateSurveyQuestionById(
            @RequestParam("id") int id) {
        surveyQuestionDao.delateSurvayQuestionById(id);
    }
}
