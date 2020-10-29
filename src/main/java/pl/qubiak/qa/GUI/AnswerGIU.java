package pl.qubiak.qa.GUI;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import pl.qubiak.qa.DAO.QaDAO;
import pl.qubiak.qa.Model.QaModel;

public class AnswerGIU extends VerticalLayout {

    private TextField textFieldId;
    private TextField textFieldAnswer;
    private Button button;
    private QaDAO qaDAO;

    @Autowired
    public AnswerGIU(QaDAO qaDAO) {

        this.textFieldId = new TextField("ID");
        this.textFieldAnswer = new TextField("Answer");
        this.button = new Button("Save");
        this.qaDAO = qaDAO;

        button.addClickListener(x -> {
            QaModel qa = new QaModel(
                    Integer.parseInt(textFieldId.getValue()),
                    textFieldAnswer.getValue());
            qaDAO.saveAnswer(qa);
        });
    }
}
