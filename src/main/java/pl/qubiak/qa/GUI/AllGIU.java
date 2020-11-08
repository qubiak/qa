package pl.qubiak.qa.GUI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.qubiak.qa.DAO.QaDAO;


@Route
public class AllGIU extends FormLayout {

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
        this.textAreaQuestion = new TextArea("Question");
        this.textAreaAnswer = new TextArea("Answer");
        this.buttonSaveQuestion = new Button("Save Question");
        this.buttonSaveAnswer = new Button("Save Answer");
        this.buttonLike = new Button("Like");
        this.buttonDissLike = new Button("DissLike");

        ObjectMapper objectMapper = new ObjectMapper();

        for (int i = 0; i < qaDAO.showEverything().size(); i++) {
            this.textAreaQuestionAndAnswer = new TextArea("Question: " + (i + 1) + " LikeCount: " + qaDAO.showEverything().get(i).getCounter());

            String question = qaDAO.showEverything().get(i).getQuestion();
            String answer = qaDAO.showEverything().get(i).getAnswer();
//jak zrobić by odpowiedź była w linijce pod pytaniem?
            textAreaQuestionAndAnswer.setValue(objectMapper.writeValueAsString(question + answer));
            add(textAreaQuestionAndAnswer);

        }

        textAreaQuestionAndAnswer.addFocusListener(x -> {
//jak tu zrobić by zamiast 1 pobierało się pytanie tego klikniętego textAreaQuestionAndAnswer?
            String question = qaDAO.showEverything().get(1).getQuestion();
            String answer = qaDAO.showEverything().get(1).getAnswer();
            try {
                textAreaQuestion.setValue(objectMapper.writeValueAsString(question));
                textAreaAnswer.setValue(objectMapper.writeValueAsString(answer));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });

        buttonSaveQuestion.addClickListener( x -> {
            qaDAO.saveQuestion(textAreaQuestion.getValue());
        });

        buttonSaveAnswer.addClickListener( x -> {
            qaDAO.saveAnswer(Integer.parseInt( /* jak tu pobrać id z klikniętego textAreaQuestionAndAnswer*/ textAreaAnswer.getValue());
        });
//by dokończyć buttonLikw i buttonDissLike musze wiedzieć jak pobrać id

        buttonLike.addClickListener( x -> {
            qaDAO.readAcctuallyLiktCounter();
            qaDAO.saveLikeCounter();
        });

        buttonDissLike.addClickListener( x -> {
            qaDAO.readAcctuallyLiktCounter();
            qaDAO.saveDissLikeCounter();
        });

        add(textAreaQuestion, textAreaAnswer, buttonSaveQuestion, buttonSaveAnswer, buttonLike, buttonDissLike);

    }
}





