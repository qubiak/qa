package pl.qubiak.qa.GUI;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.qubiak.qa.DAO.QaDAO;
import pl.qubiak.qa.Model.QaModel;

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
    public LikeAndUnlikeGIU(QaDAO qaDAO) {

        this.textAreaAllQuestion = new TextArea("All question");
        this.textAreaQuestionByLikeCounter = new TextArea("All question after sorting");
        this.textFieldId = new TextField("id");
        this.buttonLike = new Button("Like");
        this.buttonDisslike = new Button("DissLike");
        this.qaDAO = qaDAO;

        List<QaModel> QaMapAll = qaDAO.showEverything();
        textAreaAllQuestion.setValue(QaMapAll.toString());

        buttonLike.addClickListener( x -> {
            int acctuallyLikeCounter = qaDAO.readAcctuallyLiktCounter(Integer.parseInt(textFieldId.getValue()));
            qaDAO.saveLikeCounter(Integer.parseInt(textFieldId.getValue()), acctuallyLikeCounter+1);
        });

        buttonLike.addClickListener( x -> {
            qaDAO.saveDissLikeCounter(Integer.parseInt(textFieldId.getValue()));
        });
        add(textAreaAllQuestion, textFieldId, buttonLike, buttonDisslike, textAreaQuestionByLikeCounter);



    }
}
