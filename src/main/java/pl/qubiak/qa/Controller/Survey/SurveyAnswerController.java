package pl.qubiak.qa.Controller.Survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.qubiak.qa.DAO.Survey.SurveyAnswerDao;

@Controller
@RequestMapping("/SurveyAnswer")
public class SurveyAnswerController {

    @Autowired
    public SurveyAnswerDao surveyAnswerDao;

    @RequestMapping("/addSurvayAnswer")
    @ResponseBody
    //http://localhost:8080/SurveyAnswer/addSurvayAnswer?surveyQuestionId=2&surveyAnswer=testowaOdpowiedz
    public void addSurvayAnswer(
            @RequestParam("surveyQuestionId") int surveyQuestionId,
            @RequestParam("surveyAnswer") String surveyAnswer) {
        surveyAnswerDao.addSurvayAnswer(surveyQuestionId, surveyAnswer);
    }

    @RequestMapping("/delateSurveyAnswerByID")
    @ResponseBody
    //http://localhost:8080/SurveyAnswer/delateSurveyAnswerByID?id=1
    public void delateSurveyAnswerByID(
            @RequestParam("id") int id) {
        surveyAnswerDao.delateSurveyAnswerByID(id);
    }

    @RequestMapping("/editSurveyAnswer")
    @ResponseBody
    //http://localhost:8080/SurveyAnswer/editSurveyAnswer?id=2&surveyAnswer=edytowanaOdpowiedz
    public void editSurveyAnswer(
            @RequestParam("id") int id,
            @RequestParam("surveyAnswer") String surveyAnswer) {
        surveyAnswerDao.editSurveyAnswer(id, surveyAnswer);
    }

    @RequestMapping("/readAcctuallyNumberOfSelections")
    @ResponseBody
    //http://localhost:8080/SurveyAnswer/readAcctuallyNumberOfSelections?id=2
    public int readAcctuallyNumberOfSelections(
            @RequestParam("id") int id) {
        return surveyAnswerDao.readAcctuallyNumberOfSelections(id);
    }

    @RequestMapping("/voteSurveyAnswer")
    @ResponseBody
    //http://localhost:8080/SurveyAnswer/voteSurveyAnswer?id=2
    public void voteSurveyAnswer(
            @RequestParam("id") int id) {
        surveyAnswerDao.voteSurveyAnswer(id);
    }
}
