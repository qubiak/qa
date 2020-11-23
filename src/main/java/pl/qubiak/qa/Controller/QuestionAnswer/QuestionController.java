package pl.qubiak.qa.Controller.QuestionAnswer;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.qubiak.qa.DAO.QuestionAnswer.QuestionDao;
import pl.qubiak.qa.Model.QuestionAnswer.Question;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Question")
public class QuestionController {

    @Autowired
    public QuestionDao questionDAO;

    @ApiOperation(value = "create new question")
    @RequestMapping("/saveQuestion")
    @ResponseBody
    //http://localhost:8080/Question/saveQuestion?question=test&roomId=1
    public void saveQuestion(@ApiParam(value = "new question", example = "is the earth round?")
                             @RequestParam("question") String question,
                             @RequestParam("roomId") int roomId) {

        questionDAO.saveQuestion(question, roomId);
    }

    @RequestMapping("/showAllQuestions")
    @ResponseBody
    //http://localhost:8080/Question/showAllQuestions
    public List<Question> showAllQuestions() {
        return questionDAO.showEverything();
    }

    @RequestMapping("/showQuestionsById")
    @ResponseBody
    //http://localhost:8080/Question/showQuestionsById?id=15
    public List<Map<String, Object>> showQuestionsById(
            @RequestParam("id") int id) {
        return questionDAO.showById(id);
    }

    @RequestMapping("/showByRoomId")
    @ResponseBody
    //http://localhost:8080/Question/showByRoomId?roomId=1
    public List<Map<String, Object>> showQuestionByRoomId(
            @RequestParam("roomId") int roomId) {
        return questionDAO.showByRoomId(roomId);
    }

    @RequestMapping("/deleteAllQuestion")
    @ResponseBody
    //http://localhost:8080/Question/deleteAllQuestion
    public void deleteAllQuestion() {
        questionDAO.deleteAll();
    }

    @RequestMapping("/deleteQuestionById")
    @ResponseBody
    //http://localhost:8080/Question/deleteQuestionById?id=18
    public void deleteQuestionById(
            @RequestParam("id") int id) {
        questionDAO.deleteByID(id);
    }

    @RequestMapping("/likeCounter")
    @ResponseBody
    //http://localhost:8080/Question/likeCounter?id=19
    public void likeCounter(
            @RequestParam("id") int id) {
        questionDAO.saveLikeCounter(id);
    }

    @RequestMapping("/dissLikeCounter")
    @ResponseBody
    //http://localhost:8080/Question/dissLikeCounter?id=19
    public void dissLikeCounter(
            @RequestParam("id") int id) {
        questionDAO.saveDissLikeCounter(id);
    }

    @RequestMapping("/readAcctualyLikeCounter")
    @ResponseBody
    //http://localhost:8080/Question/readAcctualyLikeCounter?id=19
    public int readAcctualyLikeCounter(
            @RequestParam("id") int id) {
        return questionDAO.readAcctuallyLiktCounter(id);
    }
}
