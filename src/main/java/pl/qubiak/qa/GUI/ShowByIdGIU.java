package pl.qubiak.qa.GUI;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import pl.qubiak.qa.DAO.QaDAO;
import java.util.List;
import java.util.Map;

@Route
public class ShowByIdGIU extends VerticalLayout {

    private TextField textFieldId;
    private TextArea textArea;
    private Button button;
    private QaDAO qaDAO;

    public ShowByIdGIU(QaDAO qaDAO) {
        this.textFieldId = new TextField("ID");
        this.textArea = new TextArea();
        this.button = new Button("Show");
        this.qaDAO = qaDAO;

        button.addClickListener(x -> {
            List<Map<String, Object>> QaMapById = qaDAO.showById(Integer.parseInt(textFieldId.getValue()));
            textArea.setValue(QaMapById.toString());
        });
        add(textFieldId, textArea, button);
    }

}
