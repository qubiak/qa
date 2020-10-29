package pl.qubiak.qa.GUI;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.qubiak.qa.DAO.QaDAO;
import pl.qubiak.qa.Model.QaModel;

@Route
public class QuestionGUI extends VerticalLayout {

    private TextField textFieldId;
    private TextField textFieldQuestion;
    private Button button;
    private QaDAO qaDAO;

    @Autowired
    public QuestionGUI(QaDAO qaDAO) {

        this.textFieldId = new TextField("ID");
        this.textFieldQuestion = new TextField("Question");
        this.button = new Button("Save");
        this.qaDAO = qaDAO;

        button.addClickListener(x -> {
            QaModel qa = new QaModel(
                    Integer.parseInt(textFieldId.getValue()),
                    textFieldQuestion.getValue());
            qaDAO.saveQuestion(qa);
        });
    }
}
