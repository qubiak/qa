package pl.qubiak.qa.GUI;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.qubiak.qa.DAO.QaDAO;
import java.util.List;
import java.util.Map;

@Route
public class DelateByIdGIU extends VerticalLayout {

    private TextArea textAreaAllQuestion;
    private TextField textFieldId;
    private Button button;
    private QaDAO qaDAO;

    @Autowired
    public DelateByIdGIU(QaDAO qaDAO) {

        this.textAreaAllQuestion = new TextArea("All question");
        this.textFieldId = new TextField("ID");
        this.button = new Button("Delate");
        this.qaDAO = qaDAO;

        List<Map<String, Object>> QaMapAll = qaDAO.showIdAndQuestion();
        textAreaAllQuestion.setValue(QaMapAll.toString());

        button.addClickListener(x -> {
                    qaDAO.delateByID(Integer.parseInt(textFieldId.getValue()));
        });

        add(textAreaAllQuestion, textFieldId, button);
    }
}
