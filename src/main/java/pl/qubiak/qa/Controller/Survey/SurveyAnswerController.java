package pl.qubiak.qa.Controller.Survey;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.qubiak.qa.DAO.Survey.SurveyAnswerDao;

@Controller
@RequestMapping("/SurveyAnswer")
public class SurveyAnswerController {

    public SurveyAnswerDao surveyAnswerDao;

    @RequestMapping("/addSurvayAnswer")
    public void addSurvayAnswer(
            @RequestParam("surveyQuestionId") int surveyQuestionId,
            @RequestParam("surveyAnswer") String surveyAnswer) {
        surveyAnswerDao.addSurvayAnswer(surveyQuestionId, surveyAnswer);
    }

    @RequestMapping("delateSurveyAnswerByID")
    public void delateSurveyAnswerByID(
            @RequestParam("id") int id) {
        surveyAnswerDao.delateSurveyAnswerByID(id);
    }

    @RequestMapping("editSurveyAnswer")
    public void editSurveyAnswer(
            @RequestParam("id") int id,
            @RequestParam("surveyAnswer") String surveyAnswer) {
        surveyAnswerDao.editSurveyAnswer(id, surveyAnswer);
    }

    @RequestMapping("/readAcctuallyNumberOfSelections")
    public void readAcctuallyNumberOfSelections(
            @RequestParam("id") int id) {
        surveyAnswerDao.readAcctuallyNumberOfSelections(id);
    }

    @RequestMapping("voteSurveyAnswer")
    public void voteSurveyAnswer(
            @RequestParam("id") int id) {
        surveyAnswerDao.voteSurveyAnswer(id);
    }
}
