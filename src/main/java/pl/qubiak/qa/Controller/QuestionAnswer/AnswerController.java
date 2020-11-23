package pl.qubiak.qa.Controller.QuestionAnswer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.qubiak.qa.DAO.QuestionAnswer.AnswerDao;
import pl.qubiak.qa.Model.QuestionAnswer.Answer;
import java.util.List;

@Controller
@RequestMapping("/Answer")
public class AnswerController {

    @Autowired
    public AnswerDao answerDAO;

    @RequestMapping("/saveAnswer")
    @ResponseBody
    //http://localhost:8080/Answer/saveAnswer?questionId=19&answer=odpowiedz
    public void saveAnswer(
            @RequestParam("questionId") int questionId,
            @RequestParam("answer") String answer) {
        answerDAO.saveAnswer(questionId, answer);
    }

    @RequestMapping("/showEverythingFromAnswer")
    @ResponseBody
    //http://localhost:8080/Answer/showEverythingFromAnswer
    public List<Answer> showEverythingFromAnswer() {
        return answerDAO.showEverythingFromAnswer();
    }

    @RequestMapping("/showAnswerByQuestionId")
    @ResponseBody
    //http://localhost:8080/Answer/showAnswerByQuestionId?questionId=7
    public List<Answer> showAnswerByQuestionId(
            @RequestParam("questionId") int questionId) {
        return answerDAO.showAnswerByQuestionId(questionId);
    }

    @RequestMapping("/editAnswer")
    @ResponseBody
    //http://localhost:8080/Answer/editAnswer?id=3&question=test
    public void editAnswer(
            @RequestParam("id") int id,
            @RequestParam("question") String question) {
        answerDAO.editAnswer(id, question);
    }
}
