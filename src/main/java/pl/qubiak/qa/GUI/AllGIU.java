package pl.qubiak.qa.GUI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.qubiak.qa.DAO.QaDAO;
import pl.qubiak.qa.Model.QaModel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Route
public class AllGIU extends VerticalLayout {

    private TextArea textAreaQuestionAndAnswer;
    private TextArea textAreaQuestion;
    private TextArea textAreaAnswer;
    private Button buttonLike;
    private Button buttonDissLike;
    private Button buttonSaveQuestion;
    private Button buttonSaveAnswer;
    private QaDAO qaDAO;

    @Autowired
    public AllGIU(QaDAO qaDAO) throws JsonProcessingException {

        this.qaDAO = qaDAO;


        for (int i = 0; i < qaDAO.showEverything().size(); i++) {
            this.textAreaQuestionAndAnswer = new TextArea("Question: " + (i +1) + " LikeCount: " + qaDAO.showEverything().get(i).getCounter());

            ObjectMapper objectMapper = new ObjectMapper();
            String question = qaDAO.showEverything().get(i).getQuestion();
            String answer = qaDAO.showEverything().get(i).getAnswer();

            textAreaQuestionAndAnswer.setValue(objectMapper.writeValueAsString(question + answer));

            add(textAreaQuestionAndAnswer);

        }
    }
}





