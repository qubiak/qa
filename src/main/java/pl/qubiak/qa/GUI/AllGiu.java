package pl.qubiak.qa.GUI;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.qubiak.qa.DAO.QuestionAnswer.AnswerDao;
import pl.qubiak.qa.DAO.QuestionAnswer.QuestionDao;
import pl.qubiak.qa.Model.QuestionAnswer.Answer;
import pl.qubiak.qa.Model.QuestionAnswer.Question;
import pl.qubiak.qa.Sorting.SortByCounter;
import java.util.Collections;
import java.util.List;

@Route
public class AllGiu extends VerticalLayout {

    private QuestionDao questionDAO;
    private AnswerDao answerDAO;

    @Autowired
    public AllGiu(AnswerDao answerDAO, QuestionDao questionDAO) {
        this.questionDAO = questionDAO;
        this.answerDAO = answerDAO;

        List<Question> allQuestions = questionDAO.showEverything();

        add(new H1("Question and Answer"));
        TextArea emptyQuestionTextArea = new TextArea("Add new Question");
        Button buttonSaveQuestion = new Button("Save new question");
        Collections.sort(allQuestions, new SortByCounter());
        add(emptyQuestionTextArea, buttonSaveQuestion);
        for (int i = 0; i < allQuestions.size(); i++) {
            int finalI = i;
            TextArea questionTextArea = new TextArea("Question: " + allQuestions.get(i).getId() + " LikeCount: " + allQuestions.get(i).getLike_counter());

            Button buttonLike = new Button("+");
            Button buttonDissLike = new Button("-");


            questionTextArea.setValue(allQuestions.get(i).getQuestion());

            add(new HorizontalLayout(questionTextArea, new Label("")),
                    new HorizontalLayout(buttonLike, buttonDissLike));

            List<Answer> answerByQuestionId = answerDAO.showAnswerByQuestionId(allQuestions.get(i).getId());
            TextArea newAnswerTextArea = new TextArea("new answer:");
            for (int j = 0; j < answerByQuestionId.size(); j++) {
                TextArea answerTextArea = new TextArea("Answer:");
                if (answerByQuestionId.get(j).getAnswer() == null) {
                    answerTextArea.setValue("---");
                } else
                    answerTextArea.setValue(answerByQuestionId.get(j).getAnswer());

                add(new HorizontalLayout(new Label(), answerTextArea));

                Button buttonEditAnswer = new Button("Edit answer");
                buttonEditAnswer.addClickListener(x -> {
                    answerDAO.editAnswer(answerByQuestionId.get(finalI).getId(), answerTextArea.getValue());
                });
                add(buttonEditAnswer);



                buttonSaveQuestion.addClickListener(x -> {
                    questionDAO.saveQuestion(emptyQuestionTextArea.getValue(), 0);
                });
            }
            add(newAnswerTextArea);
            Button buttonNewSaveAnswer = new Button("Save Answer");
            buttonNewSaveAnswer.addClickListener(x -> {
                answerDAO.saveAnswer(allQuestions.get(finalI).getId(), newAnswerTextArea.getValue());
            });
            add(buttonNewSaveAnswer);

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



