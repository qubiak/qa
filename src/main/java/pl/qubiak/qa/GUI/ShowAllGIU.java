package pl.qubiak.qa.GUI;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import pl.qubiak.qa.DAO.QaDAO;
import pl.qubiak.qa.Model.QaModel;

import java.util.List;
import java.util.Map;

@Route
public class ShowAllGIU extends VerticalLayout {

    private TextArea textArea;
    private Button button;
    private QaDAO qaDAO;

    public ShowAllGIU(QaDAO qaDAO) {
        this.textArea = new TextArea();
        this.button = new Button("Show All");
        this.qaDAO = qaDAO;

        button.addClickListener(X -> {
            List<QaModel> QaMapAll = qaDAO.showEverything();
            textArea.setValue(QaMapAll.toString());
        });
        add(textArea, button);
    }
}
