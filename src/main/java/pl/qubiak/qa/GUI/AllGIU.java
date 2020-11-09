package pl.qubiak.qa.GUI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.qubiak.qa.DAO.AnswerDAO;
import pl.qubiak.qa.DAO.QuestionDAO;
import pl.qubiak.qa.Model.Answer;
import pl.qubiak.qa.Model.Question;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Route
public class AllGIU extends VerticalLayout {

    private QuestionDAO questionDAO;
    private AnswerDAO answerDAO;

    @Autowired
    public AllGIU(AnswerDAO answerDAO, QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
        this.answerDAO = answerDAO;

        List<Question> allQuestions = questionDAO.showEverything();
        List<Answer> allAnswer = answerDAO.showEverythingFromAnswer();
        add(new H1("Question and Answer"));

        for (int i = 0; i < allQuestions.size(); i++) {
            class sortByCounter implements Comparator<Question> {
                public int compare(Question a, Question b) {
                    return b.getCounter() - a.getCounter();
                }
            }
            Collections.sort(allQuestions, new sortByCounter());

            TextArea questionTextArea = new TextArea("Question: " + allQuestions.get(i).getId() + " LikeCount: " + allQuestions.get(i).getCounter());
            Button buttonLike = new Button("+");
            Button buttonDissLike = new Button("-");

            questionTextArea.setValue(allQuestions.get(i).getQuestion());

            add(questionTextArea,
                    new HorizontalLayout(buttonLike, buttonDissLike));

            TextArea answerTextArea = new TextArea("Answer:");

            if (allAnswer.get(i).getAnswer() == null) {
                answerTextArea.setValue("");
            } else
                answerTextArea.setValue(allAnswer.get(i).getAnswer());

            add(new HorizontalLayout(new Label(), answerTextArea));

            Button buttonSaveAnswer = new Button("Save Answer");
            int finalI = i;
            buttonSaveAnswer.addClickListener(x -> {
                answerDAO.saveAnswer(allQuestions.get(finalI).getId(), answerTextArea.getValue());
            });
            add(buttonSaveAnswer);

            buttonLike.addClickListener(x -> {
                questionDAO.readAcctuallyLiktCounter(allQuestions.get(finalI).getId());
                questionDAO.saveLikeCounter(allQuestions.get(finalI).getId());
            });

            buttonDissLike.addClickListener(x -> {
                questionDAO.readAcctuallyLiktCounter(allQuestions.get(finalI).getId());
                questionDAO.saveDissLikeCounter(allQuestions.get(finalI).getId());
            });
        }
    }
}