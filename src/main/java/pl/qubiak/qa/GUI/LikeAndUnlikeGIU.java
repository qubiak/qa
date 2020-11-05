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

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Route
public class LikeAndUnlikeGIU extends VerticalLayout {

    private TextArea textAreaAllQuestion;
    private TextArea textAreaQuestionByLikeCounter;
    private TextField textFieldId;
    private Button buttonLike;
    private Button buttonDisslike;
    private QaDAO qaDAO;

    @Autowired
    public LikeAndUnlikeGIU(QaDAO qaDAO) throws JsonProcessingException {

        this.textAreaAllQuestion = new TextArea("All question");
        this.textAreaQuestionByLikeCounter = new TextArea("All question after sorting");
        this.textFieldId = new TextField("id");
        this.buttonLike = new Button("Like");
        this.buttonDisslike = new Button("DissLike");
        this.qaDAO = qaDAO;

        ObjectMapper objectMapper = new ObjectMapper();
        List<QaModel> QaMapAll = qaDAO.showEverything();

            textAreaAllQuestion.setValue(objectMapper.writeValueAsString(QaMapAll));


        buttonLike.addClickListener(x -> {
            qaDAO.readAcctuallyLiktCounter(Integer.parseInt(textFieldId.getValue()));
            qaDAO.saveLikeCounter(Integer.parseInt(textFieldId.getValue()));
        });

        buttonDisslike.addClickListener(x -> {
            qaDAO.readAcctuallyLiktCounter(Integer.parseInt(textFieldId.getValue()));
            qaDAO.saveDissLikeCounter(Integer.parseInt(textFieldId.getValue()));

        });
        add(textAreaAllQuestion, textFieldId, buttonLike, buttonDisslike, textAreaQuestionByLikeCounter);

        class sortByCounter implements Comparator<QaModel> {
            public int compare(QaModel a, QaModel b) {
                return a.getCounter() - b.getCounter();
            }
        }

        Collections.sort(QaMapAll, new sortByCounter());
            textAreaQuestionByLikeCounter.setValue(objectMapper.writeValueAsString(QaMapAll));


    }
}
