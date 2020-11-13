package pl.qubiak.qa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.qubiak.qa.DAO.QuestionDao;

@Controller
public class QuestionController {

    @Autowired
    public QuestionDao questionDAO;

    @RequestMapping("/saveQuestion")
    @ResponseBody
    public void saveQuestion(
            @RequestParam("question") String question) {
        questionDAO.saveQuestion(question);
    }

    @RequestMapping("/showAllQuestions")
    @ResponseBody
    public void showAllQuestions() {
        questionDAO.showEverything();
    }

    @RequestMapping("/showQuestionsById")
    @ResponseBody
    public void showQuestionsById(
            @RequestParam("id") int id) {
            questionDAO.showById(id);
    }

    @RequestMapping("/delateAllQuestion")
    @ResponseBody
    public void delateAllQuestion(){
        questionDAO.delateAll();
    }

    @RequestMapping("/delateQuestionById")
    @ResponseBody
    public void delateQuestionById(
            @RequestParam("id") int id) {
        questionDAO.delateByID(id);
    }

    @RequestMapping("/likeCounter")
    @ResponseBody
    public void likeCounter(
            @RequestParam("id") int id) {
        questionDAO.readAcctuallyLiktCounter(id);
        questionDAO.saveLikeCounter(id);
    }

    @RequestMapping("/dissLikeCounter")
    @ResponseBody
    public void dissLikeCounter(
            @RequestParam("id") int id) {
        questionDAO.readAcctuallyLiktCounter(id);
        questionDAO.saveDissLikeCounter(id);
    }
}
