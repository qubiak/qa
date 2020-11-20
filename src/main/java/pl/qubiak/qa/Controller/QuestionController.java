package pl.qubiak.qa.Controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.qubiak.qa.DAO.QuestionDao;
import pl.qubiak.qa.Model.Question;

import java.util.List;

@Controller
@RequestMapping("/Question")
public class QuestionController {

    @Autowired
    public QuestionDao questionDAO;

    @ApiOperation(value = "create new question")
    @RequestMapping("/saveQuestion")
    @ResponseBody
    public void saveQuestion(@ApiParam(value = "new question", example = "is the earth round?")
                             @RequestParam("question") String question,
                             @RequestParam("roomId") int roomId) {

        questionDAO.saveQuestion(question, roomId);
    }

    @RequestMapping("/showAllQuestions")
    @ResponseBody
    public List<Question> showAllQuestions() {
        return questionDAO.showEverything();
    }

    @RequestMapping("/showQuestionsById")
    @ResponseBody
    public void showQuestionsById(
            @RequestParam("id") int id) {
        questionDAO.showById(id);
    }

    public void showQuestionByRoomId(
            @RequestParam("roomId") int roomId) {
        questionDAO.showByRoomId(roomId);
    }


    @RequestMapping("/delateAllQuestion")
    @ResponseBody
    public void delateAllQuestion() {
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
