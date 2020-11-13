package pl.qubiak.qa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.qubiak.qa.DAO.AnswerDao;

@Controller
public class AnswerController {

    @Autowired
    public AnswerDao answerDAO;

    @RequestMapping("/saveAnswer")
    @ResponseBody
    public void saveAnswer(
            @RequestParam("questionId") int questionId,
            @RequestParam("answer") String answer) {
        answerDAO.saveAnswer(questionId, answer);
    }

    @RequestMapping("/showEverythingFromAnswer")
    @ResponseBody
    public void showEverythingFromAnswer() {
        answerDAO.showEverythingFromAnswer();
    }

    @RequestMapping("/showAnswerByQuestionId")
    @ResponseBody
    public void showAnswerByQuestionId(
            @RequestParam("id") int id) {
        answerDAO.showAnswerByQuestionId(id);
    }

    public void editAnswer(
            @RequestParam("id") int id,
            @RequestParam("question") String question) {
        answerDAO.editAnswer(id, question);
    }
}
