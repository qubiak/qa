package pl.qubiak.qa.GUI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.qubiak.qa.DAO.QaDAO;
import pl.qubiak.qa.Model.QaModel;

import java.util.List;
import java.util.Map;

@Route
public class AnswerGIU extends VerticalLayout {

    private TextArea textAreaAllQuestion;
    private TextField textFieldId;
    private TextField textFieldAnswer;
    private Button button;
    private QaDAO qaDAO;

    @Autowired
    public AnswerGIU(QaDAO qaDAO) {

        this.textAreaAllQuestion = new TextArea("All question");
        this.textFieldId = new TextField("ID");
        this.textFieldAnswer = new TextField("Answer");
        this.button = new Button("Save");
        this.qaDAO = qaDAO;

        ObjectMapper objectMapper = new ObjectMapper();
        List<QaModel> QaMapAll = qaDAO.showEverything();
        try {
            textAreaAllQuestion.setValue(objectMapper.writeValueAsString(QaMapAll));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        button.addClickListener(x -> {
                    qaDAO.saveAnswer(Integer.parseInt(textFieldId.getValue()), textFieldAnswer.getValue());
        });

        add(textAreaAllQuestion, textFieldId, textFieldAnswer, button);
    }
}
