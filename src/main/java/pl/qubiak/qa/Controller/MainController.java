package pl.qubiak.qa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.qubiak.qa.Model.Question;
import pl.qubiak.qa.Repository.AnswerRepository;
import pl.qubiak.qa.Repository.QuestionRepository;


@Controller
public class MainController {

    @Autowired
    public QuestionRepository questionRepository;
    @Autowired
    public AnswerRepository answerRepository;
    StringBuilder response = new StringBuilder();

    @RequestMapping("/saveQuestion")
    @ResponseBody
    public String saveQuestion(
            @RequestParam("question") String question) {

        Question task = new Question()
                .withQuestion(question)
                .withCounter(0);
        questionRepository.save(task);

        return response.toString();
    }

    @RequestMapping("/showAllQuestions")
    @ResponseBody
    public String showAllQuestions() {
        for (Question i : questionRepository.findAll()) {
            response.append(i).append("<br");
        }
        return response.toString();
    }

    @RequestMapping("/showQuestionsById")
    @ResponseBody
    public String showQuestionsById(
            @RequestParam("id") int id) {
        questionRepository.findById((long) id);

        return response.toString();
    }

    @RequestMapping("delateAllQuestion")
    @ResponseBody
    public String delateAllQuestion(){
        questionRepository.deleteAll();

        return response.toString();
    }

    @RequestMapping("delateQuestionById")
    @ResponseBody
    public String delateQuestionById(
            @RequestParam("id") int id) {
        questionRepository.deleteById((long) id);

        return response.toString();
    }
}
